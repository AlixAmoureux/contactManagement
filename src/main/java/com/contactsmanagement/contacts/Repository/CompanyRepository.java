package com.contactsmanagement.contacts.Repository;

import java.util.List;
import java.util.Optional;

import com.contactsmanagement.contacts.Entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<Company> findAll();

    Optional<Company> findById(Integer id);
}
