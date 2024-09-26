package com.example.activity3_adapter;

public class User {

    private String name;
    private int age;
    private String gender;
    private String email;
    private String country;

    public User(String nam, int ag, String gen, String em, String cnt) {
        this.name = nam;
        this.age = ag;
        this.gender = gen;
        this.email = em;
        this.country = cnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
