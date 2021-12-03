package com.globallogic.PersonDemo.Repository;

import com.globallogic.PersonDemo.Model.Person;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends MongoRepository<Person,Long> {

}
