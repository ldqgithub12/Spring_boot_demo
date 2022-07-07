package com.demospring.Springtutorial.repositories;

import com.demospring.Springtutorial.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
