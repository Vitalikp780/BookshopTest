package com.example.bookshopprovectus.contollers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookshopprovectus.models.Author;
import com.example.bookshopprovectus.models.Book;
import com.example.bookshopprovectus.models.Order;
import com.example.bookshopprovectus.models.User;
import com.example.bookshopprovectus.repositories.OrderRepository;
import com.example.bookshopprovectus.repositories.UserRepository;

/**
 * 
 * @author Vitaly
 *
 */

@Controller
public class OrderController extends SecurityContextHolder {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/orders")
	private String getOrder(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("contentPage", "orders");
		return "index";
	}
	
	@PostMapping("/bookInfo")
	private String getOrder(@ModelAttribute("order") Order order, @ModelAttribute("book") Book book) {
		order.setName(book.getName());
		orderRepository.saveAndFlush(order);
		return "redirect:/orderForUser";
	}
	
	@GetMapping("/orderForUser")
	private String getOrderForUser(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("contentPage", "orderForUser");
		return "index";
	}
}