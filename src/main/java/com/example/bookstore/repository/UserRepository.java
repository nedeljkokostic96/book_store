package com.example.bookstore.repository;

import com.example.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     User findById(int id);

     @Query("select u from User u where u.firstName like :firstName")
     User findByFirstName(@PathVariable("firstName") String firstName);
}
