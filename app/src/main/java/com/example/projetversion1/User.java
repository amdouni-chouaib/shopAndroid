package com.example.projetversion1;

public class User {
    private String firstname,lastname,phone;

    private String Email;


    private String Password;


    private String RePassword;

    public User() {
    }

    public User(String firstname, String lastname, String phone, String email, String password, String rePassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        Email = email;
        Password = password;
        RePassword = rePassword;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRePassword() {
        return RePassword;
    }

    public void setRePassword(String rePassword) {
        RePassword = rePassword;
    }
}
