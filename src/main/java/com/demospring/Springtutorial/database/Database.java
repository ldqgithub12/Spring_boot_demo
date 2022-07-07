package com.demospring.Springtutorial.database;

import com.demospring.Springtutorial.models.Product;
import com.demospring.Springtutorial.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product = new Product("iporn",2022,2400.0,"");
                Product product1 = new Product("iporn 13",2022,2400.0,"");
                logger.info("insert data + "+productRepository.save(product));
                logger.info("insert data + "+productRepository.save(product1));
            }
        };
    }
}
