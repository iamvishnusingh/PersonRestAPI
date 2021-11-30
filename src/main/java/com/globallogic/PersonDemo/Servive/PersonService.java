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
        return repository.findAll();
    }

    @Override
    public Person getPersonById(Long personId) {
        return repository.findById(personId).get();
    }

    @Override
    public void deletePersonById(Long personId) {
        repository.deleteById(personId);

    }
}
