package com.example.bookstore.controller;

import com.example.bookstore.entity.Writer;
import com.example.bookstore.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriterController {

    @Autowired
    WriterService writerService;

    @GetMapping(value = "/getWriters")
    public ResponseEntity<?> getAllWriters(){
        return writerService.getAllWriters();
    }
    @GetMapping(value = "/getWriters/orderedByBirthYear")
    public ResponseEntity<?> getAllWritersOrderByDateOfBirth(){
        return writerService.getAllWritersOrderByDateOfBirth();
    }
    @GetMapping(value = "/getWriterByBook")
    public ResponseEntity<?> getWriterByBook(@RequestParam(value = "title") String title){
        Writer writer = writerService.getWriterByBook(title);
        return ResponseEntity.ok(writer);
    }

}
