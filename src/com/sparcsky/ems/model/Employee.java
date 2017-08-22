package com.sparcsky.ems.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private String email;
    private String password;
    private PersonInfo personInfo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonalInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }
    public String getFirstName(){
        return personInfo.getFirstName();
    }
}