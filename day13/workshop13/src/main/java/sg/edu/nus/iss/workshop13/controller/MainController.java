package sg.edu.nus.iss.workshop13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.workshop13.model.Contact;
import sg.edu.nus.iss.workshop13.repo.ContactRepo;

@Controller
@RequestMapping
public class MainController {

//     @GetMapping(path={"/", "/home"})
//     public String home() {
//         return "home";
//   }

    @Autowired
    ContactRepo contactRepo;

    @GetMapping(path={"/","/listing", "/home"})
    public String contactList(Model model) {
        // List<Contact> conts = contactRepo.findAll();
        // model.addAttribute("conts", conts);

        model.addAttribute("contact", new Contact());

        return "home";
    }

    @PostMapping(path="/listing")
    public String save (@Valid @ModelAttribute("contact") Contact contact, BindingResult br, Model model) {
        //the @Valid is in front of the @ModelAttribute to validate contact
        model.addAttribute("showcons", contact);
        br.hasErrors();
        return "list";
    }

    
}
