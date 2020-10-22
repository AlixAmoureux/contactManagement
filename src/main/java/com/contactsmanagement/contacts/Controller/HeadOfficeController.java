package com.contactsmanagement.contacts.Controller;

import com.contactsmanagement.contacts.Entity.Company;
import com.contactsmanagement.contacts.Entity.HeadOffice;
import com.contactsmanagement.contacts.Repository.CompanyRepository;
import com.contactsmanagement.contacts.Repository.HeadOfficeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "company/{companyId}/headOffice")
public class HeadOfficeController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private HeadOfficeRepository headOfficeRepository;

    /**
     * Create head office for the company
     * 
     * @param companyId : id of the company
     * @param headOffice : head office entity
     * @return : head office entity created
     */
    @PostMapping
    public HeadOffice createHeadOffice(@PathVariable("companyId") Integer companyId, @RequestBody HeadOffice headOffice)
    {
        Company company = this.companyRepository.findById(companyId).get();
        headOffice.setHeadOfficeCompany(company);
        return this.headOfficeRepository.save(headOffice);
    }
}
