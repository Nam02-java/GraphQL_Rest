package com.example.Second_Step.BookService;

import com.example.Second_Step.Repositories.ProductRepository;
import com.example.Second_Step.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    ProductRepository productRepository;

    public String getName(int id){
        return productRepository.findById((long) id).get().getName();
    }

    public String getName_Demo(){
        return productRepository.findAll().get(1).getLast_name();
    }

}
