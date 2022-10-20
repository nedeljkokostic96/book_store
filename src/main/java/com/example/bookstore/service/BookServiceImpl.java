package com.example.bookstore.service;

import com.example.bookstore.controller.mapper.BookMapper;
import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Writer;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    WriterRepository writerRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByWriter(int idWriter) {
        Writer writer = new Writer();
        writer.setIdW(idWriter);
        List<Book> books = bookRepository.findByWriter(writer);
        return books;
    }

    @Override
    public ResponseEntity<?> saveBook(Book book) {
        Book savedBook = bookRepository.save(book);

        if(savedBook != null){
            return ResponseEntity.ok("Book is saved");
        }else{
            return ResponseEntity.badRequest().body("FAILED !");
        }
    }

    @Override
    public List<BookResponse> getBooksByGenre(int genre) {
        return bookRepository.getBooksByGenre(genre)
                .stream()
                .map(x -> BookMapper.mapEntityToResponse(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getALlBooksCheaperThenPrice(double price) {
        List<Book> books = bookRepository.findAll();
       return books
               .stream()
               .filter(x-> x.getPrice() < price)
               .collect(Collectors.toList());

    }

    @Override
    public List<Book> getBooksByPriceBetweenPrices(double priceFrom, double priceTo) {
        List<Book> books = bookRepository.findAll();
        return books
                .stream()
                .filter(x->x.getPrice()>priceFrom && x.getPrice()< priceTo)
                .collect(Collectors.toList());

    }
}
