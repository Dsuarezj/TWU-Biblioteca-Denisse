package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    private List<String> masterUser = new ArrayList<>();

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

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return masterUser != null ? masterUser.equals(user.masterUser) : user.masterUser == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (masterUser != null ? masterUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ("name: " + this.name + "\n" +
                "email: " + this.email + "\n" +
                "address : " + this.address + "\n" +
                "phone number: " + this.phoneNumber) + "\n";
    }


}
