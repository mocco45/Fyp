package com.example.sencusapp;

public class Registered_Agent {

    String firstname;
    String lastname;
    String email;
    String phone_number;
    String password;

    public Registered_Agent() {

    }

    public Registered_Agent(String firstname, String lastname, String email, String phone_number, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }
}




