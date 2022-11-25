package com.example.testprojecy;

public class StudentRequest {
    String name;
    String age;
    String address;
    String id;

    public StudentRequest(String id, String name , String age, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String  getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
