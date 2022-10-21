package com.example.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "bookstore",name = "db_user")
public class User {

    @Id
    @Column(name = "ID",nullable = false,unique = true)
    private Integer id;
    @Column(name = "firstname",nullable = false)
    private String firstName;
    @Column(name = "lastname",nullable = false)
    private String lastName;
    @Column(name = "password",nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_ID")
    private Role role;
}
