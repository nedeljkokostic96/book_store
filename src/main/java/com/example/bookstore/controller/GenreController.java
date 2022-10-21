package com.example.bookstore.controller;

import com.example.bookstore.entity.Genre;
import com.example.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/genre-by-title")
    public ResponseEntity<?> getGenreByTitle(@RequestParam(value = "title") String title){
        Genre genre = genreService.findByTitle(title);
        return ResponseEntity.ok(genre);
    }



}
