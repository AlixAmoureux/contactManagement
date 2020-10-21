package com.contactsmanagement.contacts.Controller;

import java.util.List;

import com.contactsmanagement.contacts.Entity.Company;
import com.contactsmanagement.contacts.Repository.CompanyRepository;

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
@RequestMapping(value = "/company")
public class CompanyController
{
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Get all companies
     * 
     * @return : all the companies
     */
    @GetMapping
    public List<Company> getAllCompanies()
    {
        logger.info("GET ALL COMPANIES");
        return (this.companyRepository.findAll());
    }

    /**
     * Create a company
     */
    @PostMapping
    public Company createCompany(@RequestBody Company company)
    {
        return (this.companyRepository.save(company));
    }

    /**
     * Update a company
     * 
     * @param id : id of the company
     * @param company : the company infos
     * @return : the company updated
     */
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company company)
    {
        company.setId(id);
        return (this.companyRepository.save(company));
    }

    /**
     * Delete a company
     * 
     * @param id : id of the company to delete
     */
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Integer id)
    {
        this.companyRepository.deleteById(id);
    }
}