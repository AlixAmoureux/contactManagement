package com.contactsmanagement.contacts.Controller;

import com.contactsmanagement.contacts.Entity.Agency;
import com.contactsmanagement.contacts.Entity.Company;
import com.contactsmanagement.contacts.Repository.AgencyRepository;
import com.contactsmanagement.contacts.Repository.CompanyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "company/{companyId}/headOffice")
public class HeadOfficeController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AgencyRepository agencyRepository;

/*    @PostMapping
    public Agency setHeadOffice(@PathVariable("companyId") Integer companyId, @RequestBody Agency agency)
    {
        Company company = this.companyRepository.findById(companyId).get();
        agency.setHeadOffice(company);
        return this.agencyRepository.save(agency);
    }*/
}
