package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column
    private String name;
    private String lastname;
    private String email;
    private String phonenumber;
    private String password;

    // Constructors, getters, setters
    // You can generate these using your IDE or manually

    public User() {
    }

    public User(String name, String lastname, String email, String phonenumber, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}