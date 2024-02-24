package com.softuni.mobilelelesoftuni.init;

import com.softuni.mobilelelesoftuni.models.entities.User;
import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import com.softuni.mobilelelesoftuni.repositories.UserRepository;
import com.softuni.mobilelelesoftuni.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private final String test_p;

    @Autowired
    public DataInitializer(@Value("${mobilelele.test_p}") String test_p,
                           UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
//        this.defaultAdminPass = defaultAdminPass;
        this.test_p = test_p;
    }

    @Override
    public void run(String... args) throws Exception {

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());

        UserRole adminRole = new UserRole();
        UserRole userRole = new UserRole();

        adminRole.setRole(Role.ADMIN);
        userRole.setRole(Role.USER);

        userRoleRepository.save(adminRole);
        userRoleRepository.save(userRole);

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setFirstName("Dracula" + i);
            user.setLastName("Morningstar" + i);
            user.setActive(true);
            user.setUsername("draci" + i);
            //test
            user.setPassword(test_p);
            user.setCreated(time);
            user.setModified(time);


            if (i % 3 == 0) {
                user.setRoles(List.of(userRole, adminRole));
            } else {
                user.setRoles(List.of(userRole));
            }

            userRepository.save(user);
        }
    }
}
