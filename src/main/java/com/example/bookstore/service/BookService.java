package com.example.bookstore.service;

import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByWriter(int idWriter);

    ResponseEntity<?> saveBook(Book book);

    List<BookResponse> getBooksByGenre(int genre);

    List<Book> getALlBooksCheaperThenPrice(double price);
}
