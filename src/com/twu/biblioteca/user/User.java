package com.twu.biblioteca.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User {

    private String id;
    private Password password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String id, Password password, String name, String email, String address, String phoneNumber) {
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

    public Password getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

    @Override
    public String toString() {
        return ("name: " + this.name + "\n" +
                "email: " + this.email + "\n" +
                "address : " + this.address + "\n" +
                "phone number: " + this.phoneNumber) + "\n";
    }


}
