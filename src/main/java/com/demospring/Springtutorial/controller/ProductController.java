package com.demospring.Springtutorial.controller;

import com.demospring.Springtutorial.models.Product;
import com.demospring.Springtutorial.models.ResponseObject;
import com.demospring.Springtutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id){
        Optional<Product> foundProduct = productRepository.findById(id);
        if (foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "find product successfully", foundProduct)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","Can not find product with id = "+id,"")
            );
        }
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(
          new ResponseObject("Ok","Insert successfully",productRepository.save(product))
        );
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> upgradeProduct(@RequestBody Product newProduct, @PathVariable Integer id){
        Product upgradeProduct = productRepository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setRelease_year(newProduct.getRelease_year());
                    product.setPrice(newProduct.getPrice());
                    product.setImg_url(newProduct.getImg_url());
                    return productRepository.save(product);
                })
                .orElseGet(()->{
                    newProduct.setId_product(id);
                    return productRepository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","upgrade successfully",upgradeProduct)
        );
        }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Integer id){
        boolean isExist = productRepository.existsById(id);
        if (isExist){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","delete successfully","")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ResponseObject("fail","can not find product with id : "+id,"")
            );
        }
    }
}

