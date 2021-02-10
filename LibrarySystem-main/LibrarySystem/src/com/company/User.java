package com.company;

public class User {

    String surname;
    String name;
    Long iin;

    public User(){

    }


    public Long getIIN() {
        return iin;
    }
    public void setIIN(Long iin) {
        this.iin=iin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
