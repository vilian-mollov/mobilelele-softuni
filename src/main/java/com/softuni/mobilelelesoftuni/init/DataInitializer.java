package com.softuni.mobilelelesoftuni.init;

import com.softuni.mobilelelesoftuni.models.entities.User;
import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import com.softuni.mobilelelesoftuni.repositories.UserRepository;
import com.softuni.mobilelelesoftuni.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());

        for (int i = 1; i <= 10; i++) {
        User user = new User();
        user.setFirstName("Elon" + i);
        user.setLastName("Musk" + i);
        user.setActive(true);
        user.setUsername("user" + i);
        user.setPassword("text" + i);
        user.setCreated(time);
        user.setModified(time);

        userRepository.save(user);

        UserRole userRole = new UserRole();
        if(i % 3 == 0){
            userRole.setName(Role.Admin);
        }else {
            userRole.setName(Role.User);
        }

        userRoleRepository.save(userRole);

        user.setRole(userRole);
        userRepository.save(user);

        }


    }
}
