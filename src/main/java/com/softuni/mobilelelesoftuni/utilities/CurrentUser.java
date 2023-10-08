package com.softuni.mobilelelesoftuni.utilities;

import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;
    private String lastName;
    private String username;
    private boolean isLogged;

    private Role role;


    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void logout() {
        setLogged(false);
        setUsername(null);
    }

    public Role getRole() {
        return role;
    }

    public CurrentUser setRole(Role role) {
        this.role = role;
        return this;
    }
}
