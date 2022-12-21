package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);
    void loginUser(UserServiceModel userServiceModel);
    UserServiceModel findByUsernameAndPassword(String username, String password);
    UserServiceModel findById(Long id);
    void logout();
    boolean isLogged();
}
