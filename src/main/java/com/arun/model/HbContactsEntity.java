package com.arun.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Hibernate Entity for contact table in database. This has the information regarding the addressbook contacts in the database
 * Created by Arun on 2/27/2017.
 */
@Entity
@Table(name = "contacts", schema = "AddressBook", catalog = "")
public class HbContactsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idcontact;
    private int iduser;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontact", nullable = false)
    public int getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(int idcontact) {
        this.idcontact = idcontact;
    }

    // IMPORTANT: iduser is NOT a primary key, so NO @Id here
    @Basic
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "contact_name", nullable = true, length = -1)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contact_email", nullable = true, length = -1)
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "contact_phone", nullable = true, length = 20)
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Basic
    @Column(name = "contact_address", nullable = true, length = -1)
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HbContactsEntity that = (HbContactsEntity) o;

        if (idcontact != that.idcontact) return false;
        if (iduser != that.iduser) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        return contactAddress != null ? contactAddress.equals(that.contactAddress) : that.contactAddress == null;
    }

    @Override
    public int hashCode() {
        int result = idcontact;
        result = 31 * result + iduser;
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (contactAddress != null ? contactAddress.hashCode() : 0);
        return result;
    }
}