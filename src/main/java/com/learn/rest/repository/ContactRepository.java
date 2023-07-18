package com.learn.rest.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.learn.rest.entiy.Contact;



@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByContactGroup(String group);

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByLastName(String lastName);

    Contact findByEmail(String email);



}
