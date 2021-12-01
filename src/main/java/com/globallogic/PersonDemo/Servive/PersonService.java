package com.globallogic.PersonDemo.Servive;

import com.globallogic.PersonDemo.CustomException.ServiceException;
import com.globallogic.PersonDemo.Model.Person;
import com.globallogic.PersonDemo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService  implements  PersonServiveInterface{

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }



    public Person SavePerson(Person person) {

        if(person.getFirstName().isEmpty() || person.getFirstName().length()==0){
            throw  new ServiceException("601","Please Provide Valid FirstName , It is Blank");
        }

        try{
            return repository.save(person);
        }catch (IllegalArgumentException e){
            throw  new ServiceException("602","given Employee is null "+e.getMessage());
        }catch (Exception e){
            throw  new ServiceException("603","Something Wrong in Service Layer"+e.getMessage());
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList=null;
        try {
            personList= repository.findAll();
        }catch (Exception e){
            throw new ServiceException("610","Something Went Wrong in Service Layer While Deleting Employee"+e.getMessage());
        }
        if(personList.isEmpty()){
          throw new ServiceException("604","List is Empty we have nothing to Return");
        }
        return personList;
    }

    @Override
    public Person getPersonById(Long personId) {
        try {
            return repository.findById(personId).get();
        }catch (IllegalArgumentException ie){
            throw  new ServiceException("606","Given Person id is Null ,Please Send Proper Id to Searched"+ie.getMessage());

        }catch (java.util.NoSuchElementException e){
            throw new ServiceException("607","No such Person id Exist in DB"+e.getMessage());
        }
        catch (Exception e){
            throw new ServiceException("610","Something Went Wrong in Service Layer While Deleting Employee"+e.getMessage());
        }

    }

    @Override
    public void deletePersonById(Long personId) {

        try {
            repository.deleteById(personId);
        }
        catch (IllegalArgumentException ie){
            throw  new ServiceException("608","Given Person id is Null ,Please Send Proper Id"+ie.getMessage());

        }catch (Exception e){
            throw new ServiceException("610","Something Went Wrong in Service Layer While Deleting Employee"+e.getMessage());
        }


    }
}
