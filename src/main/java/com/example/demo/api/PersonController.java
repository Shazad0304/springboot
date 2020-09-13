package com.example.demo.api;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/person")
@RestController
public class PersonController {
    private final PersonService ps;

    @Autowired
    public PersonController(PersonService ps) {
        this.ps = ps;
    }

    @PostMapping
    public void addPersion(@RequestBody Person person){
        ps.addPerson(person);
    }

    @GetMapping
    public List<Person> getAll(){
    return ps.getAll();
    }

    @GetMapping(path = "{id}")
    public Person getByid(@PathVariable("id") UUID id){
        return ps.ByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public boolean Delete(@PathVariable("id") UUID id){
        return ps.Delete(id);
    }

    @PutMapping(path = "{id}")
    public boolean update(@PathVariable("id") UUID id,@RequestBody Person p){
        return ps.updatePerson(id,p);
    }

}
