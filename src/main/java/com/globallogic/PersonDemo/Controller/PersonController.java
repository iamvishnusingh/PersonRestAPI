package com.globallogic.PersonDemo.Controller;

import com.globallogic.PersonDemo.Model.Person;
import com.globallogic.PersonDemo.Servive.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping(value ="/save" ,produces = {"application/json"})
    public ResponseEntity<?> SaveUser(@RequestBody Person person){
        try {
            Person local_person=service.SavePerson(person);
            return  new ResponseEntity<>(local_person,HttpStatus.CREATED);

        }
        catch (Exception e){
            return  new ResponseEntity<>("Message : "+e.getMessage(), HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> listAllperson=service.getAllPerson();
        return  new ResponseEntity<List<Person>>(listAllperson,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        Person person=service.getPersonById(id);
        return  new ResponseEntity<>(person,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        service.deletePersonById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }

}
