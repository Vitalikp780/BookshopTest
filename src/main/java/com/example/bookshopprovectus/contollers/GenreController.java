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
import com.example.bookshopprovectus.repositories.BookRepository;
import com.example.bookshopprovectus.repositories.GenreRepository;

/**
 * 
 * @author Vitaly
 *
 */

@Controller
public class GenreController {
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/genres")
	private String getIndex(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("contentPage", "genres");
		return "index";
	}

	@GetMapping("/genres/{genresId}")
	private String getAuthorBooks(Model model, @PathVariable int genresId) {
		List<Book> books = new ArrayList<Book>();
		List<Genre> genres = new ArrayList<Genre>();
		List<Book> repoBooks = bookRepository.findAll();

		for (Book book : repoBooks) {
			genres = book.getGenres();
			for (Genre genre : genres) {
				if (genre.getId().equals(genresId)) {
					books.add(book);
				}
			}
		}

		model.addAttribute("books", books);
		model.addAttribute("contentPage", "books");
		return "index";
	}

	@GetMapping("/genres/add")
	private String addGenre(@ModelAttribute Genre genre, Model model) {
		model.addAttribute("contentPage", "addGenre");
		return "index";
	}

	@PostMapping("/genres/add")
	private String addGenre(@ModelAttribute Genre genre) {
		genreRepository.saveAndFlush(genre);
		return "redirect:/genres";
	}
}
