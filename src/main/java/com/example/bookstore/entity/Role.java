package com.example.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "bookstore", name = "role")
public class Role {

    @Id
    @Column(name = "ID", nullable = false,unique = true)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @OneToMany(mappedBy ="role",fetch = FetchType.LAZY)
    private List<User> userList;
}
