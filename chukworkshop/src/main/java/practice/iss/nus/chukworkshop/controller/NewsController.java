package practice.iss.nus.chukworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practice.iss.nus.chukworkshop.service.NewService;

@Controller
@RequestMapping("/")
public class NewsController {
    
    @Autowired
    NewService newsSvc;

    // GET view1 home page
    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("category", newsSvc.getCategories());
        model.addAttribute("country", newsSvc.getCountry());

        return "view1";

    }

    // GET /news?country=sg&category=technology
    @GetMapping ("/news")
    public String getNews(@RequestParam String country, @RequestParam String category, Model model) {
        model.addAttribute("country", country);
        model.addAttribute("news", newsSvc.getNews(category, country));
        return "view2";
    }
}
