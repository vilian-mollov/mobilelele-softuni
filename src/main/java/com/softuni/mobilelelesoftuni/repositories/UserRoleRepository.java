package com.softuni.mobilelelesoftuni.repositories;

import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
