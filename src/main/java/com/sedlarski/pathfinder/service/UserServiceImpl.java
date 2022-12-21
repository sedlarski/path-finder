package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.entity.User;
import com.sedlarski.pathfinder.model.entity.enums.UserLevelEnum;
import com.sedlarski.pathfinder.model.service.UserServiceModel;
import com.sedlarski.pathfinder.repository.UserRepository;
import com.sedlarski.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(UserLevelEnum.BEGINNER);
        userRepository.save(user);
    }



    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setId(userServiceModel.getId());
    }

    @Override
    public void logout() {
        currentUser.setUsername(null);
        currentUser.setId(null);
    }

    @Override
    public boolean isLogged() {
        return currentUser.getId() != null;
    }
}
