package com.example.Second_Step.Controller;

import com.example.Second_Step.Repositories.ProductRepository;
import com.example.Second_Step.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/get/name")
public class Person_Controller {

    /**
     * @Autowired tạo 1 lần khi app khởi chạy sẽ dùng mãi mãi
     */
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Person> getAllName() {
        return repository.findAll();
    }

}


//    return List.of(new Person("nam", "truong", "hanoi", "A"),
//                new Person("an", "nguyen", "hanoi", "C"),
//                new Person("giang", "ha", "haiduong", "B"));