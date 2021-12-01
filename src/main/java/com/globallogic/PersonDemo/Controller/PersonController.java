package com.globallogic.PersonDemo.Controller;

import com.globallogic.PersonDemo.CustomException.ControllerException;
import com.globallogic.PersonDemo.CustomException.ServiceException;
import com.globallogic.PersonDemo.Model.Person;
import com.globallogic.PersonDemo.Servive.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        catch (ServiceException se){
            ControllerException ce=new ControllerException(se.getErrorCode(),se.getErrorMessage());
            return  new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce= new ControllerException("611","Something Went Wrong in Controller");
            return  new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> listAllperson=service.getAllPerson();
        return  new ResponseEntity<List<Person>>(listAllperson,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        try {
            Person person=service.getPersonById(id);
            return  new ResponseEntity<>(person,HttpStatus.OK);
        }catch (ServiceException se){
            ControllerException ce=new ControllerException(se.getErrorCode(),se.getErrorMessage());
            return  new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce= new ControllerException("612","Something Went Wrong in Controller");
            return  new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

        }

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        service.deletePersonById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person person1=service.SavePerson(person);
        return new ResponseEntity<Person>(person1,HttpStatus.CREATED);
    }



}
