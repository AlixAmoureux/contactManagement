package com.contactsmanagement.contacts.Controller;

import java.util.List;

import com.contactsmanagement.contacts.Entity.Contact;
import com.contactsmanagement.contacts.Repository.ContactRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository contactRepository;

    /**
     * Get all contacts
     */
    @GetMapping()
    public List<Contact> getAllContacts() {
        logger.info("GET ALL CONTACTS");
        return (this.contactRepository.findAll());
    }

    /**
     * Create a contact
     * 
     * @param contact : contact to create
     * @return : contact created
     */
    @PostMapping()
    public Contact createContact(@RequestBody Contact contact) {
        logger.info("CREATE CONTACT");
        return (this.contactRepository.save(contact));
    }

    /**
     * Update a contact
     * 
     * @param contact : contact to update (DO NOT FORGET THE ID in the path !)
     * @return : contact updated
     */
    @PutMapping("{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        contact.setId(id);
        return (this.contactRepository.save(contact));
    }

    /**
     * Delete a contact
     * 
     * @param id : id od the contact to delete
     */
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Integer id) {
        this.contactRepository.deleteById(id);
    }

    /**
     * Delete all the contacts
     */
    @DeleteMapping()
    public void deleteAllContacts() {
        this.contactRepository.deleteAll();
    }
}
