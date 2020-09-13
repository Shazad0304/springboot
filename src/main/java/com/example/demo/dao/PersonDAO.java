package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    boolean insertPerson(UUID id, Person person);

    default boolean addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getAllPeople();

    boolean deletePerson(UUID id);

    boolean updatePerson(UUID id,Person person);

    Optional<Person> getByid(UUID id);
}
