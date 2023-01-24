package com.pondit.design_patterns;

public class BuilderPattern {

    public static void main(String[] args) {
//        Student mainul = new Student("Mainul", );

    }
}


class Student {
    private String name;
    private int age;
    private Address address;

    private String dept;

    private String session;

    private String parentPhoneNumber;

    private String labGroup;

    private String deptHeadName;


    public Student() {
    }

    public Student(String name, int age, Address address, String dept, String session, String parentPhoneNumber, String labGroup, String deptHeadName) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dept = dept;
        this.session = session;
        this.parentPhoneNumber = parentPhoneNumber;
        this.labGroup = labGroup;
        this.deptHeadName = deptHeadName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}

class Address {
    private String country;
    private String city;
    private String district;
    private String policeStation;
    private String street;
    private int postCode;

    public Address() {
    }

    public Address(String country, String city, String district, String policeStation, String street, int postCode) {
        this.country = country;
        this.city = city;
        this.district = district;
        this.policeStation = policeStation;
        this.street = street;
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}