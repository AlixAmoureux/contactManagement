package com.contactsmanagement.contacts.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="COMPANY")
public class Company implements Serializable {

    /**
     * For Serializable interface
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

/*     @OneToOne(mappedBy = "headOffice", targetEntity = Agency.class)
    @JsonManagedReference
    private Agency headOffice; */

    @OneToMany(mappedBy = "company", targetEntity = Agency.class)
    @JsonManagedReference
    private List<Agency> agencies;

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

/*     public Agency getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(Agency headOffice) {
        this.headOffice = headOffice;
    } */

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
}
