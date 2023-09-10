package com.github.MikeMwita.empAPI.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="users")

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",nullable=false)
    private String name ;

    @Column(name="username",nullable=false,unique = true)
    private String username;

    @Column(name="password",nullable=false)

    private String password;
    @Column(name="active",nullable=false)

    private int active;

    @Column(name="created_at",nullable=false)

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name="updated_at",nullable=true)

    private Timestamp updatedAt;


}
