package com.example.bookstore.service;

import com.example.bookstore.entity.Writer;
import com.example.bookstore.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    WriterRepository writerRepository;

    @Override
    public ResponseEntity<?> getAllWriters() {
        List<Writer> writers = writerRepository.findAll();
        return ResponseEntity.ok(writers);
    }
}
