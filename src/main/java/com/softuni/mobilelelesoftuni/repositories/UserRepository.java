package com.softuni.mobilelelesoftuni.repositories;

import com.softuni.mobilelelesoftuni.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
