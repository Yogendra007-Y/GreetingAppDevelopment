package com.example.demo.model.repository;

import com.example.demo.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting,Long> {
}