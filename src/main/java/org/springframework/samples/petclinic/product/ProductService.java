package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.findTypeByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }
    public List<ProductType> findAllProductTypes(){
        return productRepository.findAllProductTypes();
    }
    
}
