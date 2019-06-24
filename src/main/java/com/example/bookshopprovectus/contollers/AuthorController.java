package com.example.bookshopprovectus.contollers;

import java.util.ArrayList;
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

/**
 * 
 * @author Vitaly
 *
 */

@Controller
public class AuthorController {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/authors")
	private String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		model.addAttribute("contentPage", "authors");
		return "index";
	}

	@GetMapping("/authors/{authorsId}")
	private String getAuthorBooks(Model model, @PathVariable int authorsId) {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors = new ArrayList<Author>();
		List<Book> repoBooks = bookRepository.findAll();
		for (Book book : repoBooks) {
			authors = book.getAuthors();
			for (Author author : authors) {
				if (author.getId().equals(authorsId)) {
					books.add(book);
				}
			}
		}
		model.addAttribute("books", books);
		model.addAttribute("contentPage", "books");
		return "index";
	}

	@GetMapping("/authors/add")
	private String addAuthor(@ModelAttribute Author author, Model model) {
		model.addAttribute("contentPage", "addAuthor");
		return "index";
	}

	@PostMapping("/authors/add")
	private String addAuthor(@ModelAttribute Author author) {
		authorRepository.saveAndFlush(author);
		return "redirect:/authors";
	}
}
