package com.example.Second_Step.DataBase;

import com.example.Second_Step.Repositories.ProductRepository;
import com.example.Second_Step.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Person person1 = new Person("nam", "truong", "hn", "A");
                Person person2 = new Person("an", "nguyen", "hn", "C");
                Person person3 = new Person("chau", "dang", "hn", "B");
                logger.info("insert data : " + productRepository.save(person1));
                logger.info("insert data : " + productRepository.save(person2));
                logger.info("insert data : " + productRepository.save(person3));

            }
        };
    }
}
