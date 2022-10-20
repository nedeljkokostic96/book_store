package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT b FROM Book b WHERE b.writer = :writer")
    List<Book> findByWriter(Writer writer);

    @Query(value = "SELECT * FROM book b WHERE b.id IN (SELECT bg.book_id FROM bookgenre bg WHERE bg.genre_id = :genre)", nativeQuery = true)
    List<Book> getBooksByGenre(@Param("genre") int genre);
}
