package sg.edu.nus.iss.workshop13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/home")
public class HomeController {
    
    @GetMapping
    public String home() {
        return "home";
    }

}