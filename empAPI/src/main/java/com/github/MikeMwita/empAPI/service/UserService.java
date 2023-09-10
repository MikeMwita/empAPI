package com.github.MikeMwita.empAPI.service;


import com.github.MikeMwita.empAPI.entity.User;
import com.github.MikeMwita.empAPI.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class UserService {

    //CRUD
    //CreateUser,UpdateUser,ViewUsers,DeleteUsers
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepo userRepo;

    public User createUser(User user){
        try {

            //validations
            //save to db
            //send mail

//            String sql="INSERT INTO USERS(name,password,usename)VALUES(?,?,?)";
//            jdbcTemplate.update(sql,new Object(){user.getName(),user.getPassword,user.getUsername})
userRepo.save(user);

// send mail
            return user;


        }catch (Exception e){
            log.error("Eeror occured ",e);
            return null;
        }
    }


    public String updateUser(User user ){

        try {
            log.info("Received an update request for {}",user.getUsername());
//            String sql ="UPDATE users set name=?....where id=?";
//            jdbcTemplate.update();
//            userRepo.save(user);

            return  "success";
        }catch (Exception e ){
            log.error("error occured ",e);
            return null;
        }

    }



    public List<User>viewUsers(int pageSize,int pageNumber,String search){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User>userPage=userRepo.findAll(pageable);

//        Page userPage =userRepo.findAllByNameContainingOrderByIdDesc(name,pageable);
        return userPage.getContent();

//        long totalElements = userPage.getTotalElements();
//        int totalPages = userPage.getTotalPages();
//        return userPage.getContent();

//        Pageable pageable= PageRequest.of(pageNumber,pageSize);
//        Page userPage = userRepo.findAll(pageable);
//
//        userPage.getTotalPages();
//        userPage.getTotalElements();
//        String sql="SELECT id,name,username FROM users order by id desc LIMIT 10 OFFSET 20";

//    return userRepo.findAll(pageable);
    }

    public String deleteUser(User user){
        userRepo.delete(user);
        return "success";
    }


}
