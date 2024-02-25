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
        userRepository.deleteAll();
        userRoleRepository.deleteAll();

        UserRole adminRole = new UserRole();
        UserRole userRole = new UserRole();

        insertRolesToDb(adminRole, userRole);

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());

        User admin = getUser("Jack", "Sparrow", true, "rum_lover", test_p, time, List.of(adminRole, userRole));
        User user = getUser("Bruse", "Wayne", true, "regular_guy", test_p, time, List.of(userRole));

        userRepository.save(admin);
        userRepository.save(user);
    }

    private void insertRolesToDb(UserRole adminRole, UserRole userRole) {
        adminRole.setRole(Role.ADMIN);
        userRole.setRole(Role.USER);

        userRoleRepository.save(adminRole);
        userRoleRepository.save(userRole);
    }

    private static User getUser(String first_name, String last_name, Boolean is_active, String username, String test_p, Timestamp time, List<UserRole> roles) {
        return new User(username, test_p, first_name, last_name, is_active, "", time, time, roles);
    }
}
