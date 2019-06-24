package com.example.bookshopprovectus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshopprovectus.models.Author;

/**
 * 
 * @author Vitaly
 *
 */

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
