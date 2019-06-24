package com.example.bookshopprovectus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshopprovectus.models.Book;

/**
 * 
 * @author Vitaly
 *
 */

public interface BookRepository extends JpaRepository<Book, Integer>{

}
