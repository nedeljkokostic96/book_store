package com.example.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "bookstore", name = "book")
public class Book {

    @Id
    @Column(name = "ID",nullable = false,unique = true)
    private Integer id;
    private String title;
    private String description;
    private double price;

    @OneToMany
    @JoinColumn(name = "writer_id")
    private Writer writer;
}
