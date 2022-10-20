package com.example.bookstore.service;

import com.example.bookstore.entity.Writer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WriterService {

    public ResponseEntity<?> getAllWriters();


}
