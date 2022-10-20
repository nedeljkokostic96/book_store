package com.example.bookstore.repository;

import com.example.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query("SELECT g FROM Genre g where g.title=:title")
     Genre findByTitle(@Param("title") String title);
}
