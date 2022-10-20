package com.example.bookstore.controller;


import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/books-by-writer")
    public ResponseEntity<?> getByWriter(@RequestParam(value = "writer") int writer) {
        List<Book> bookList = bookService.getBooksByWriter(writer);
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/books/writers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookByWriter(@RequestParam(value = "writer") String writer) {
        System.out.println(writer);
        List<Book> bookList = bookService.getBooksByWriter(Integer.parseInt(writer));
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/books-by-genre")
    public ResponseEntity<?> getBooksByGenre(@RequestParam(value = "genre") int genre) {
        List<BookResponse> bookList = bookService.getBooksByGenre(genre);
        return ResponseEntity.ok(bookList);
    }

    @PostMapping(value = "/books",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBook(@RequestBody Book book){

        return bookService.saveBook(book);
    }


}
