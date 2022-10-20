package com.example.bookstore.service;

import com.example.bookstore.entity.Genre;
import com.example.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;


    @Override
    public Genre findByTitle(String title) {
        Genre genre = genreRepository.findByTitle(title);
        return genre;
    }
}
