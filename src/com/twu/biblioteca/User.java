package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class User {

    private String id;
    private String pass;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    List<String> masterUser = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");

    public User(List<String> userInformation) {
        this.id = userInformation.get(0);
        this.pass = userInformation.get(1);
        this.name = userInformation.get(2);
        this.email = userInformation.get(3);
        this.address = userInformation.get(4);
        this.phoneNumber = userInformation.get(5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return masterUser != null ? masterUser.equals(user.masterUser) : user.masterUser == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
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

    public String getId() {
        return id;
    }
}
