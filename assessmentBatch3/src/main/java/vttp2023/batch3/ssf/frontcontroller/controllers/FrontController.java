package vttp2023.batch3.ssf.frontcontroller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp2023.batch3.ssf.frontcontroller.model.User;

@Controller
@RequestMapping
public class FrontController {

	// TODO: Task 2, Task 3, Task 4, Task 6

	@GetMapping(path="/")
	public String landingPage() {

		return "view0";
	}

	@PostMapping(path="/login")
	public String processLogin(@Valid @ModelAttribute User user, BindingResult result) {
		
		// login logic here 
		if() {
			// login successful
			return "redirect:/view1";
		} else {
			// login failed
			return "view0";
		}

		if(result.hasErrors()) {
			return "view0";
		}

		return "view1";
	}
}
