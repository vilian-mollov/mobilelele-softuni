package com.softuni.mobilelelesoftuni.models.dtos;

import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;

public class CreateUserDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Role role;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
