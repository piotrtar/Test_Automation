package com.sii.Models;

import com.sii.Factory.UserFactory;
import com.sii.Helpers.DataGenerator;

public class User extends UserFactory {

    private DataGenerator dataGenerator = new DataGenerator();
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String billingAddress;
    private String billingCity;
    private String billingPostCode;
    private String shippingAddress;
    private String shippingPostCode;
    private String shippingCity;

    public User() {
        this.email = dataGenerator.getRandomEmail();
        this.password = "abasdds@!sd";
        this.firstName = dataGenerator.getRandomWord();
        this.lastName = dataGenerator.getRandomWord();
        this.phoneNumber = dataGenerator.getRandomPhoneNumber();
        this.country = "Poland";
        this.billingAddress = dataGenerator.getRandomWord();
        this.billingCity = dataGenerator.getRandomWord();
        this.billingPostCode = dataGenerator.getRandomWord();
        this.shippingAddress = dataGenerator.getRandomWord();
        this.shippingPostCode = dataGenerator.getRandomWord();
        this.shippingCity = dataGenerator.getRandomWord();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingPostCode() {
        return billingPostCode;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getShippingPostCode() {
        return shippingPostCode;
    }

    public String getShippingCity() {
        return shippingCity;
    }
}