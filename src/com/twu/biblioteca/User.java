package com.twu.biblioteca;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User {

    private String id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String id, String password, String name, String email, String address, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .append(password, user.password)
                .append(name, user.name)
                .append(email,user.email)
                .append(address,user.address)
                .append(phoneNumber,user.phoneNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(password)
                .append(name)
                .append(email)
                .append(address)
                .append(phoneNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ("name: " + this.name + "\n" +
                "email: " + this.email + "\n" +
                "address : " + this.address + "\n" +
                "phone number: " + this.phoneNumber) + "\n";
    }


}
