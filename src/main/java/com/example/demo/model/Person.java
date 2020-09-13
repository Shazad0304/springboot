package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "People")
public class Person {
    private String name;
    private UUID id;

    public Person(){

    }

    public Person(@JsonProperty("name") String name,@JsonProperty("id") UUID id) {
        this.name = name;
        this.id = id;
    }

    @Column(name = "name",nullable = false)
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Id
    public UUID getId(){
        return this.id;
    }
    public void setId(UUID id){
        this.id = id;
    }

}
