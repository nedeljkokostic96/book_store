package com.example.bookstore.controller.mapper;

import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.entity.Book;

import java.util.List;

public class BookMapper {

    public static BookResponse mapEntityToResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setDescription(book.getDescription());
        return bookResponse;
    }
}
