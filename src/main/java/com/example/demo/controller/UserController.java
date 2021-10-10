package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserDTO> getUsers(){

       List<User> userList = userService.getAllUsers();
       List<UserDTO> userDTOList = new ArrayList<>();

       for(User u: userList){
           UserDTO userDTO = UserDTO.builder()
                   .id(u.getId())
                   .name(u.getName())
                   .age(u.getAge()).build();
           userDTOList.add(userDTO);
       }

       return userDTOList;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id){

        try {
            User user = userService.getUserById(Integer.valueOf(id));
            return UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .age(user.getAge())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/")
    public UserDTO saveUser(@RequestBody  UserDTO userDTO){

        User savedUser =  userService.saveUser(userDTO);
        return UserDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .age(savedUser.getAge())
                .build();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {

        try {
            User user = userService.getUserById(Integer.valueOf(id));
            if(user != null){
                user.setName(userDTO.getName());
                user.setAge(userDTO.getAge());
                User savedUser = userService.saveUser(user);

                return new UserDTO(savedUser.getId(), savedUser.getName(), savedUser.getAge());
            }else{
                throw new RuntimeException("User not found for id " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        try {
            userService.deleteUser(Integer.valueOf(id));
            return "Delete Success";
        } catch (Exception e) {
            return "Delete Failed";
        }
    }

}
