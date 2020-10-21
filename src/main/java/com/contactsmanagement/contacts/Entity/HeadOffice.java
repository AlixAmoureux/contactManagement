package com.contactsmanagement.contacts.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="HEADOFFICE")
public class HeadOffice implements Serializable {
    /**
     * For Serializable interface
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer Id;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToOne
    @JoinColumn(name="head_office_id")
    @JsonBackReference
    private Company headOfficeCompany;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getHeadOfficeCompany() {
        return headOfficeCompany;
    }

    public void setHeadOfficeCompany(Company company) {
        this.headOfficeCompany = company;
    }
}
