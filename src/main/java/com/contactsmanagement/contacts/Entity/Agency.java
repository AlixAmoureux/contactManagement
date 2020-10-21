package com.contactsmanagement.contacts.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="AGENCY")
public class Agency implements Serializable {

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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Company.class)
    @JoinColumn(name="company_id", referencedColumnName = "id")
    @JsonBackReference
    private Company company;

/*     @OneToOne(cascade = CascadeType.ALL, targetEntity = Company.class)
    @JoinColumn (name="headOffice_id")
    @JsonBackReference
    private Company headOffice; */

    
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

/*     public Company getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(Company HeadOffice) {
        this.headOffice = HeadOffice;
    } */
}
