package com.example.Second_Step.Repositories;

import com.example.Second_Step.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Person,Long> {
}

