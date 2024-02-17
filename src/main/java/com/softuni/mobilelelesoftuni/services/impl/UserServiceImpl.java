package com.softuni.mobilelelesoftuni.services.impl;

import com.softuni.mobilelelesoftuni.models.dtos.*;
import com.softuni.mobilelelesoftuni.models.entities.User;
import com.softuni.mobilelelesoftuni.models.entities.UserRole;
import com.softuni.mobilelelesoftuni.repositories.UserRepository;
import com.softuni.mobilelelesoftuni.repositories.UserRoleRepository;
import com.softuni.mobilelelesoftuni.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
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
