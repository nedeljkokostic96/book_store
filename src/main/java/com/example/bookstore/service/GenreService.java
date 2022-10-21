package com.example.bookstore.service;

import com.example.bookstore.entity.Genre;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {

    Genre findByTitle(String title);
}
