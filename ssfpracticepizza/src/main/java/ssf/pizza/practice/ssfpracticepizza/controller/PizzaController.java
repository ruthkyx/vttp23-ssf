package ssf.pizza.practice.ssfpracticepizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ssf.pizza.practice.ssfpracticepizza.repo.PizzaRepo;

@Controller
@RequestMapping("/")
public class PizzaController {
    
    @Autowired
    private PizzaRepo pizzaRepo;

    @GetMapping
    public String landingPage() {
        // view0
        return "index";
    }

    // application/x-www-form-urlencoded typically involves using @RequestParam
    @PostMapping(produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String processOrder(){
        return "";
    }
}
