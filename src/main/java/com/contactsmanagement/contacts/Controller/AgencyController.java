package com.contactsmanagement.contacts.Controller;

import java.util.List;

import com.contactsmanagement.contacts.Entity.Agency;
import com.contactsmanagement.contacts.Entity.Company;
import com.contactsmanagement.contacts.Repository.AgencyRepository;
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
@RequestMapping(value = "company/{companyId}/agency")
public class AgencyController {
    private static final Logger logger = LoggerFactory.getLogger(AgencyController.class);

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Get all agencies
     * 
     * @return : list of agencies found
     */
    @GetMapping("/all")
    public List<Agency> getAllAgenciesForAllCompanies() {
        logger.info("GET ALL AGENCIES FOR ALL COMPANIES");
        return (this.agencyRepository.findAll());
    }

    /**
     * Get all agencies with a specific company id
     * 
     * @param id : id of the company
     * @return : list of agencies found
     */
    @GetMapping
    public List<Agency> getAllAgencies(@PathVariable("companyId") Integer id) {
        logger.info("GET ALL AGENCIES");
        return (this.agencyRepository.findAllAgenciesForACompany(id));
    }

    /**
     * Create an agency for a company
     * 
     * @param companyId : id of the company
     * @param agency : agency to create
     * @return : agency entity created
     */
    @PostMapping
    public Agency createAgency(@PathVariable("companyId") Integer companyId, @RequestBody Agency agency) {
        Company company = this.companyRepository.findById(companyId).get();
        agency.setAgencyCompany(company);
        return this.agencyRepository.save(agency);
    }

    /**
     * Update an agency
     * 
     * @param agencyId : id of the agency
     * @param agency : the agency entity
     * @return : the agency entity updated
     */
    @PutMapping("/{agencyId}")
    public Agency updateAgency(@PathVariable("agencyId") Integer agencyId, @RequestBody Agency agency) {
        agency.setId(agencyId);
        return (this.agencyRepository.save(agency));
    }

    /**
     * Delete all the agencies
     */
    @DeleteMapping("/{agencyId}")
    public void deleteAllAgencies(@PathVariable("agencyId") Integer agencyId) {
        this.agencyRepository.deleteById(agencyId);
    }
}
