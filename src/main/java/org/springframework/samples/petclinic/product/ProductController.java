package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	private static final String VIEWS_PRODUCT_CREATE = "products/createOrUpdateProductForm";
    private static final String VIEWS_PRODUCT_LISTS = "products/productList";
    
    @ModelAttribute("productTypes")
    public List<ProductType> populateProductTypes() {
        return this.productService.findAllProductTypes();
    }
    
    @Autowired
    public ProductController(ProductService productService) {
    	this.productService=productService;
    }
    
    @GetMapping
    public ModelAndView showProductList() {
        ModelAndView mav = new ModelAndView(VIEWS_PRODUCT_LISTS);
        mav.addObject("products", productService.getAllProducts());
        return mav;
    }
    
    @GetMapping("/create")
    public ModelAndView createProduct() {
    	ModelAndView model = new ModelAndView(VIEWS_PRODUCT_CREATE);
    	model.addObject("product", new Product());
    	return model;
    }
    
    @PostMapping("/create")
    public ModelAndView creationForm(@Valid Product product, BindingResult result) {
    	ModelAndView model;
    	if(result.hasErrors()) {
    		model = new ModelAndView(VIEWS_PRODUCT_CREATE);
    		model.addObject("product", product);
    		model.addObject("types", productService.findAllProductTypes());
    	} else {
    		this.productService.save(product);
    		model=new ModelAndView("welcome");
    	}
    	return model;
    }
    
}
