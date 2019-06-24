package com.example.bookshopprovectus.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Vitaly
 *
 */

@Controller
public class AdminController {
	@GetMapping(value = "/admin")
	public String getRegistrationPage() {
		return "adminIndex";
	}
}