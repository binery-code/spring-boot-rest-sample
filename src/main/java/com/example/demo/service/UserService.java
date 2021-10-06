package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) throws Exception {
            User user = userRepository.findById(userId).orElseThrow( () -> new Exception("User not found for Id" + userId));
            return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User saveUser(UserDTO userDTO){
       User savedUser =  userRepository.save(new User(userDTO.getId(), userDTO.getName(), userDTO.getAge()));
       return savedUser;
    }

    public User saveUser(User user){
       return userRepository.save(user);
    }

    public void deleteUser(int userId) throws Exception {
        try{
            userRepository.deleteById(userId);
        }catch (Exception e){
            throw new Exception(e);
        }
    }


}
