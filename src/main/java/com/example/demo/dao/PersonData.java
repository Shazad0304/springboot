package com.example.demo.dao;

import com.example.demo.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("testData")
public interface PersonData extends JpaRepository<Person,UUID> {

}
