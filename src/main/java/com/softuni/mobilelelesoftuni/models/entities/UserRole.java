package com.softuni.mobilelelesoftuni.models.entities;

import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity{

    private Role name;

    @OneToOne(targetEntity = User.class)
    private User user;

    public UserRole() {
    }

    public UserRole(Role name, User user) {
        this.name = name;
        this.user = user;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
