package com.example.bookstore.repository;

import com.example.bookstore.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriterRepository extends JpaRepository<Writer,Integer> {

    List<Writer> findAllByOrderByDateOfBirth();
    @Query(value = "select w from Writer w where w.id in (select b.writer.idW from Book b where b.title=:title)",nativeQuery = true)
    Writer findByBook(@Param("title")String title);
}
