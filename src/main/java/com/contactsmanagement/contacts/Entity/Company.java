package com.contactsmanagement.contacts.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    /**
     * For Serializable interface
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "agencyCompany")
    @JsonManagedReference
    private List<Agency> agencies;

    @OneToOne(mappedBy = "headOfficeCompany")
    @JsonManagedReference
    private HeadOffice headOffice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id")
    @JsonBackReference
    private Contact contact;

    @Column(name = "tva", nullable = true)
    private String tva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public HeadOffice getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(HeadOffice headOffice) {
        this.headOffice = headOffice;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
