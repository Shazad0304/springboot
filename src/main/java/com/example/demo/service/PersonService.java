package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.dao.PersonData;
import com.example.demo.model.Person;
import com.example.demo.sql.connectSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonData pd;

    @Autowired
    public PersonService(@Qualifier("testData") PersonData pd) {
        this.pd = pd;
    }

    public boolean addPerson(Person p){
        p.setId(UUID.randomUUID());
        this.pd.save(p);
        return true;
    }

    public List<Person> getAll(){
        return pd.findAll();
    }

    public Optional<Person> ByID(UUID id){
        return pd.findById(id);
    }

    public boolean Delete(UUID id){

         pd.deleteById(id);
         return true;
    }

    public boolean updatePerson(UUID id,Person p){

        p.setId(id);
        pd.save(p);
        return true;
    }

    public List<Person> getshz() throws SQLException {
        Statement st = connectSQL.get().createStatement();
        ResultSet rs = st.executeQuery("select * from people");
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        return pd.findShazad();
    }


}
