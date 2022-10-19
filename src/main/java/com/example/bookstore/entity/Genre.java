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
@Table(schema = "bookstore", name = "genre")
public class Genre {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "genre")
    private List<BookGenre> bookGenreList;

}
