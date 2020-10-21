package com.contactsmanagement.contacts.Repository;

import java.util.List;

import com.contactsmanagement.contacts.Entity.HeadOffice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadOfficeRepository extends CrudRepository<HeadOffice, Integer>
{
    List<HeadOffice> findAll();
}
