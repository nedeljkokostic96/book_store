package com.example.bookstore.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;
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
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    private String autobiography;
    @Column(name = "date_of_birth")
    private int dateOfBirth;
    @OneToMany(mappedBy = "writer")
    private List<Book> books;
}
