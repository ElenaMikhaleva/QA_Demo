package dto;

import enums.Gender;

public class Student {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String picture;
    private String address;
    private String state;
    private String city;

    public Student() {
    }

    public Student(String name, String lastName, String email, Gender gender, String mobile, String dateOfBirth, String subjects, String hobbies, String picture, String address, String state, String city) {
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.address = address;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
