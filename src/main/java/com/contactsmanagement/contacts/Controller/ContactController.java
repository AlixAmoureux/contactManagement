package com.contactsmanagement.contacts.Controller;

import java.util.ArrayList;
import java.util.List;

import com.contactsmanagement.contacts.Entity.Company;
import com.contactsmanagement.contacts.Entity.Contact;
import com.contactsmanagement.contacts.Repository.CompanyRepository;
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
@RequestMapping
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Get all contacts
     * @return : the contacts found
     */
    @GetMapping(value = "/contact")
    public List<Contact> getAllContacts() {
        logger.info("GET ALL CONTACTS");
        return (this.contactRepository.findAll());
    }

    /**
     * Create a contact and assign it to a company
     * 
     * @param id      : id of the company
     * @param contact : contact to create
     * @return : contact entity created
     */
    @PostMapping(value = "/contact/company/{id}")
    public Company createContact(@PathVariable Integer id, @RequestBody Contact contact) {
        logger.info("CREATE CONTACT");
        Company company = this.companyRepository.findById(id).get();
        company.setContact(contact);
        return this.companyRepository.save(company);
    }

    /**
     * Add an existing company to an existing contact
     * 
     * @param contactId : id of the contact
     * @param companyId : id of the company
     * @return : contact updated
     */
    @PostMapping(value = "/contact/{contactId}/company/{companyId}")
    public Company addACompanyToContact(@PathVariable Integer contactId, @PathVariable Integer companyId) {
        logger.info("addACompanyToContact");
        Contact contact = this.contactRepository.findById(contactId).get();
        Company company = this.companyRepository.findById(companyId).get();
        company.setContact(contact);
        return (this.companyRepository.save(company));
    }

    /**
     * Update a contact
     * 
     * @param contact : contact to update (DO NOT FORGET THE ID in the path !)
     * @return : contact updated
     */
    @PutMapping("/contact/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        contact.setId(id);
        return (this.contactRepository.save(contact));
    }

    /**
     * Delete a contact
     * 
     * @param id : id od the contact to delete
     */
    @DeleteMapping("/contact/{id}")
    public void deleteContact(@PathVariable Integer id) {
        this.contactRepository.deleteById(id);
    }

    /**
     * Delete all the contacts
     */
    @DeleteMapping("/contact")
    public void deleteAllContacts() {
        this.contactRepository.deleteAll();
    }
}
