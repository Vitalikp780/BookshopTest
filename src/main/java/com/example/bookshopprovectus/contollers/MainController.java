package com.example.bookshopprovectus.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookshopprovectus.repositories.BookRepository;

@Controller
public class MainController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	private String getIndex(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("contentPage", "books");
		return "index";
	}
}
