package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
    @Query("SELECT p FROM Product p")
	List<Product> findAll();
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Optional<Product> findById(int id);
    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Product findByName(String name);
    Product save(Product p);
    @Query("SELECT pt FROM ProductType pt WHERE pt.name=?1")
    ProductType findTypeByName(String name);
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findByPriceLessThan(double price);
}
