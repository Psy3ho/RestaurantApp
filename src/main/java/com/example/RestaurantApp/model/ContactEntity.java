package com.example.RestaurantApp.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class ContactEntity extends BaseEntity {
    @Column(name = "mail")
    private String mail;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    private String city;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
