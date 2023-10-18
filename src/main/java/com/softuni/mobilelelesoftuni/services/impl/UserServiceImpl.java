package com.softuni.mobilelelesoftuni.services.impl;

import com.softuni.mobilelelesoftuni.models.dtos.*;
import com.softuni.mobilelelesoftuni.models.entities.User;
import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import com.softuni.mobilelelesoftuni.repositories.UserRepository;
import com.softuni.mobilelelesoftuni.repositories.UserRoleRepository;
import com.softuni.mobilelelesoftuni.services.UserService;
import com.softuni.mobilelelesoftuni.utilities.CurrentUser;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Resource(name = "currentUser")
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           ModelMapper modelMapper,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public Boolean createUser(CreateUserDTO createUserDTO) {

        ConvertUserDTO convUserDTO = setConvertUser(createUserDTO);

        User user = modelMapper.map(convUserDTO, User.class);

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        user.setCreated(time);
        user.setModified(time);
        user.setActive(true);

        userRepository.save(user);

        return true;
    }

    @Override
    public Boolean loginUser(LoginUserDTO loginUserDTO) {

        Optional<User> optUser = userRepository.findByUsername(loginUserDTO.getUsername());

        boolean isLogged = false;

        if(optUser.isPresent() && loginUserDTO.getPassword().equals(optUser.get().getPassword())){
            isLogged = true;

            User user = optUser.get();

            currentUser.setLogged(true);
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setUsername(user.getUsername());
            currentUser.setRole(user.getRole().getName());

        }


        return isLogged;
    }


    private ConvertUserDTO setConvertUser(CreateUserDTO createUserDTO) {

        ConvertUserDTO convUser = new ConvertUserDTO();
        convUser.setPassword(createUserDTO.getPassword());
        convUser.setUsername(createUserDTO.getUsername());
        convUser.setFirstName(createUserDTO.getFirstName());
        convUser.setLastName(createUserDTO.getLastName());

        UserRole userRole = new UserRole(createUserDTO.getRole());

        UserRole savedRole = userRoleRepository.save(userRole);

        convUser.setRole(savedRole);

        return convUser;
    }

}
