package com.example.bookshopprovectus.contollers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookshopprovectus.models.Author;
import com.example.bookshopprovectus.models.Book;
import com.example.bookshopprovectus.models.Genre;
import com.example.bookshopprovectus.repositories.AuthorRepository;
import com.example.bookshopprovectus.repositories.BookRepository;
import com.example.bookshopprovectus.repositories.GenreRepository;

/**
 * 
 * @author Vitaly
 *
 */

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private GenreRepository genreRepository;

	@GetMapping("/books/{booksId}")
	private String getAuthorBooks(Model model, @PathVariable int booksId) {
		Book bookShow = bookRepository.getOne(booksId);
		model.addAttribute("bookShow", bookShow);
		model.addAttribute("contentPage", "bookInfo");
		return "index";
	}

	@GetMapping("/books/editBook/{id}")
	private String editBook(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("book", bookRepository.getOne(id));
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("authors", authorRepository.findAll());
		model.addAttribute("genreChecked", bookRepository.getOne(id).getGenres());
		model.addAttribute("authorsChecked", bookRepository.getOne(id).getAuthors());
		model.addAttribute("contentPage", "editBook");
		return "index";
	}

	@PostMapping("/books/editBook")
	private String editBookSubmit(@ModelAttribute("book") Book book) {
		bookRepository.saveAndFlush(book);
		return "redirect:/";
	}

	@GetMapping("/books/addBook")
	private String addBook(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("authors", authorRepository.findAll());
		model.addAttribute("contentPage", "addBook");
		return "index";
	}

	@PostMapping("/books/addBook")
	private String addBookSubmit(@ModelAttribute("book") Book book) {
		bookRepository.save(book);
		return "redirect:/";
	}
}
