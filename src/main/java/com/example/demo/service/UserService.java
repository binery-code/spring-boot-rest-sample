package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
@Log
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) throws Exception {

            log.info("Get user by Id................................");
            User user = userRepository.findById(userId).orElseThrow( () -> new Exception("User not found for Id" + userId));
            return user;
    }

    public List<User> getAllUsers(){

        log.log(Level.INFO, "Get All users....................");
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User saveUser(UserDTO userDTO){
       User savedUser =  userRepository.save(
               User.builder()
                       .id(userDTO.getId())
                       .age(userDTO.getAge())
                       .name(userDTO.getName())
                       .status(userDTO.getStatus())
                       .build());
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


    public List<User> getUsersByParams(String userName, String status, String age){
        log.info("params are username = " + userName +  "and status =" + status + " and age =" + age );

//        List l = new ArrayList();
//        l.add("test1");
//        l.add("uuu");
        //return userRepository.findByNameIn(l);

        //return  userRepository.findByNameNot("test1");
        //return userRepository.findByNameOrAge(userName, status);
        //return  userRepository.findByNameEndsWith(userName);

        return  userRepository.findByNameAndStatus(userName, status);

    }


}
