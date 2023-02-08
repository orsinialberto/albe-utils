package org.example.model;

import com.opencsv.bean.CsvBindByName;

public class CsvBean {

    @CsvBindByName(column = "externalId")
    private Integer id;

    @CsvBindByName(column = "base.contacts.email")
    private String email;

    @CsvBindByName(column = "base.firstName")
    private String firstname;

    @CsvBindByName(column = "base.lastName")
    private String lastname;

    public CsvBean(Integer id, String email, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "CsvBean{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
