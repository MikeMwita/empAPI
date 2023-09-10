package com.github.MikeMwita.empAPI.controller;


import com.github.MikeMwita.empAPI.entity.User;
import com.github.MikeMwita.empAPI.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("users")

public class UserController {

    //get,post,put,delete


@Autowired
    UserService userService;
@GetMapping
    public ResponseEntity<?>getUsers(@RequestParam(name="page")int page,@RequestParam(name="size")int size,@RequestParam(required = false,name="search")String search){
        try{
            List<User>userList=userService.viewUsers(size,page,search);
            return new ResponseEntity(userList,HttpStatus.OK);

        }catch (Exception e){
            log.error("....",e);
            return new ResponseEntity("error occured", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

@PostMapping
    public ResponseEntity<?>createUser(@RequestBody User user){
        try{
            User userResponse=userService.createUser(user);

            if (userResponse!=null){
                return new ResponseEntity(userResponse,HttpStatus.CREATED);

            }else{
                return new ResponseEntity("error creating user",HttpStatus.BAD_REQUEST);

            }


        }catch (Exception e){
            log.error("....",e);
            return new ResponseEntity("error occured", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
