package com.globallogic.PersonDemo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {


    @Id
    private long id;
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String email;
    private String mobile;
}
