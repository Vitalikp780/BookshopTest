package com.example.bookshopprovectus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshopprovectus.models.Order;

/**
 * 
 * @author Vitaly
 *
 */

public interface OrderRepository extends JpaRepository <Order, Integer>{

}
