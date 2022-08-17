package thrid_step.Controller_Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thrid_step.Model_Rest.Person_rest;
import thrid_step.Repositories_Rest.ProductRepository_Rest;

import java.util.List;

@RestController
@RequestMapping(path = "/getName")
public class Person_Controller_rest {

    @Autowired
    private ProductRepository_Rest repository_special_rest;

    @GetMapping("")
    public String getAllName(){
        return repository_special_rest.findAll().getClass().getName();
    }
}


//    @GetMapping("")
//    List<Person_rest> getAllName(){
//        return repository_special_rest.findAll();
//    }
//}

