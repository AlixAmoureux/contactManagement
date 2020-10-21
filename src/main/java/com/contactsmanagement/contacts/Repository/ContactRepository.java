package com.contactsmanagement.contacts.Repository;

import java.util.List;
import com.contactsmanagement.contacts.Entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findAll();
}
