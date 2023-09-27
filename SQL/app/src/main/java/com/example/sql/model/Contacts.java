package com.example.sql.model;

public class Contacts {
    private int id;
    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contacts(int id, String name, String phno) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phoneNumber;
    }

    public void setPhno(String phno) {
        this.phoneNumber = phno;
    }
}
