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
import java.util.List;

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

        UserRole adminRole = new UserRole();
        UserRole userRole = new UserRole();

        adminRole.setRole(Role.Admin);
        userRole.setRole(Role.User);

        userRoleRepository.save(adminRole);
        userRoleRepository.save(userRole);

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setFirstName("Elon" + i);
            user.setLastName("Musk" + i);
            user.setActive(true);
            user.setUsername("user" + i);
            //test
            user.setPassword("95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151");
            user.setCreated(time);
            user.setModified(time);


            if (i % 3 == 0) {
                user.setRole(List.of(userRole, adminRole));
            } else {
                user.setRole(List.of(userRole));
            }


            userRepository.save(user);

        }


    }
}
