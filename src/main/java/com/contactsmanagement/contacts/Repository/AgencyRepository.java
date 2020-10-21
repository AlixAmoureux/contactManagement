package com.contactsmanagement.contacts.Repository;

import java.util.List;

import com.contactsmanagement.contacts.Entity.Agency;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Integer> {

    List<Agency> findAll();
    
    @Query("select a from Agency a where a.company.id = 1")
    List<Agency> findAllAgenciesForACompany(Integer id);
}
