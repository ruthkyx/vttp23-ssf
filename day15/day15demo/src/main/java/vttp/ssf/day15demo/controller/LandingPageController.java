package vttp.ssf.day15demo.controller;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day15demo.model.Item;

// @Controller
// @RequestMapping(path={"/", "/index.html"})
public class LandingPageController {

    // @GetMapping
    public String getIndex(Model model) {

        model.addAttribute("item", new Item());
        
        return "index";
    }
}
