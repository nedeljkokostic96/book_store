package com.example.bookstore.repository;

import com.example.bookstore.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer,Integer> {

}
