package com.example.bookshopprovectus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshopprovectus.models.Genre;

/**
 * 
 * @author Vitaly
 *
 */

public interface GenreRepository extends JpaRepository <Genre, Integer> {

}
