package com.contactsmanagement.contacts.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="CONTACT")
public class Contact implements Serializable {
    
    /**
     * For Serializable interface
     */
    private static final long serialVersionUID = 3906400626060261961L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer Id;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="is_freelance", nullable = true)
    private Boolean isFreelance;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Company> contactCompanies;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsFreelance() {
        return isFreelance;
    }

    public void setIsFreelance(Boolean isFreelance) {
        this.isFreelance = isFreelance;
    }

    public List<Company> getContactCompanies() {
        return contactCompanies;
    }

    public void setContactCompanies(List<Company> contactCompanies) {
        this.contactCompanies = contactCompanies;
    }
}
