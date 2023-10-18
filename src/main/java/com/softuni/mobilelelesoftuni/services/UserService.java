package com.softuni.mobilelelesoftuni.services;

import com.softuni.mobilelelesoftuni.models.dtos.CreateUserDTO;
import com.softuni.mobilelelesoftuni.models.dtos.LoginUserDTO;

public interface UserService {

    Boolean createUser(CreateUserDTO createUserDTO);

    Boolean loginUser(LoginUserDTO loginUserDTO);

}
