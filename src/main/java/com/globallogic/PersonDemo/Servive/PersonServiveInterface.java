package com.globallogic.PersonDemo.Servive;

import com.globallogic.PersonDemo.Model.Person;

import java.util.List;

public interface PersonServiveInterface {

    public Person SavePerson(Person person);
    public List<Person> getAllPerson();
    public  Person getPersonById(Long personId);
    public  void deletePersonById(Long personId);

}
