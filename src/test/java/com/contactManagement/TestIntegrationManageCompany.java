package com.contactManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.contactsmanagement.contacts.ContactsApplication;
import com.contactsmanagement.contacts.Controller.CompanyController;
import com.contactsmanagement.contacts.Entity.Company;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ContactsApplication.class)
public class TestIntegrationManageCompany {
    
    @Autowired
    private CompanyController companyController;

    private Company createSimpleCompany()
    {
        Company company = new Company();
        company.setTva("5.2");
        company.setName("BNP");
        return company;
    }

    @Test
    public void createCompany()
    {
        Company company = this.createSimpleCompany();
        Company response = this.companyController.createCompany(company);
        assertEquals(response, company, "Company object should be the same returned");
    }

    @Test
    public void deleteCompany()
    {
        this.companyController.deleteCompany(1);
        assertEquals(this.companyController.getAllCompanies().size(), 0, "There should be no company left");
    }
}
