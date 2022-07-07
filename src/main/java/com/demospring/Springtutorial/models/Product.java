package com.demospring.Springtutorial.models;

import lombok.*;

import javax.persistence.*;

@Entity
//@Table(name = "tblProduct")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_product;
//    @Column(nullable = false,unique = true,length = 300)
    private String productName;
    private int release_year;
    private Double price;
    private String img_url;

    public Product(String productName, int year, Double price, String url) {
        this.productName = productName;
        this.release_year = year;
        this.price = price;
        this.img_url = url;
    }
}
