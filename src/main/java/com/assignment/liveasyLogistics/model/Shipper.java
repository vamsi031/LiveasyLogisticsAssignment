package com.assignment.liveasyLogistics.model;

import jakarta.persistence.*;

@Entity
public class Shipper {

    public Shipper() {
    }

    public Shipper(String shipperId, String name, String email, String phoneNumber) {

        this.Id = shipperId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Id
    private String Id;//UUID
    private String name;
    private String email;
    private String phoneNumber;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
