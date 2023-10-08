package com.softuni.mobilelelesoftuni.models.entities;

import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity{

    private Role name;

    public UserRole() {
    }

    public UserRole(Role name) {
        this.name = name;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

}
