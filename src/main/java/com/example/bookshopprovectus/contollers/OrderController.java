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


@Controller
public class OrderController extends SecurityContextHolder {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/order")
	private String getIndex(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("contentPage", "orders");
		return "index";
	}
	
	@PostMapping("/order")
	private String addAuthor(@ModelAttribute Order order) {
		orderRepository.saveAndFlush(order);
		return "redirect:/";
	}
/*	@GetMapping("/order")
	private String getOrder(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByLogin(auth.getName()).orElse(new User());
		List<Book> books = new ArrayList<Book>();
		//List<Basket> userBaskets = user.getBasket();
		for (int i = 0; i < userBaskets.size(); i++) {
			for (int j = 0; j < userBaskets.get(i).getBooks().size(); j++) {
				books.add(userBaskets.get(i).getBoo?ks().get(j));
			}
		}
		int price = 0;
		for (int i = 0; i < books.size(); i++) {
			price += books.get(i).getPrice();
		}

		model.addAttribute("book", books);
		model.addAttribute("price", price);
		model.addAttribute("contentPage", "basket");
		model.addAttribute("contentPage", "order");
		return "index";
	}*/
}