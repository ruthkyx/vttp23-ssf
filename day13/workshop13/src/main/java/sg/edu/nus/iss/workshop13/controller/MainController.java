package sg.edu.nus.iss.workshop13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.workshop13.model.Contact;
import sg.edu.nus.iss.workshop13.repo.ContactRepo;

@Controller
@RequestMapping
public class MainController {

    @GetMapping(path={"/", "/home"})
    public String home() {
        return "home";
    }

    @Autowired
    ContactRepo contactRepo;

    @GetMapping(path="/list")
    public String contactList(Model model) {
        Contact con = new Contact();
        model.addAttribute("con", con);

        return "list";
    }

    @PostMapping(path="/list")
    public String saveContact(@Validated @ModelAttribute("contact") Contact con, BindingResult br ,Model model) {

        contactRepo.save(con);

        return "redirect:/list";
    }
    
}
