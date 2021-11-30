package com.globallogic.PersonDemo.Servive;

import com.globallogic.PersonDemo.Model.Person;
import com.globallogic.PersonDemo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService  implements  PersonServiveInterface{

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }



    public Person SavePerson(Person person) {
        return repository.save(person);
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
