package com.example.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "bookstore", name = "writer")
public class Writer {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Integer idW;
    @Column(name = "firstname",nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "autobiography")
    private String autobiography;
    @Column(name = "birthyear")
    private int dateOfBirth;
    @JsonIgnore
    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Book> books;
}
