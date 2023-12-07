package sg.edu.nus.iss.workshop13.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.workshop13.model.Contact;
import sg.edu.nus.iss.workshop13.repo.ContactRepo;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    ContactRepo contactRepo;

    @GetMapping(path={"/", "/home"})
    public String contactList(Model model) {
        // List<Contact> conts = contactRepo.findAll();
        // model.addAttribute("conts", conts);

        model.addAttribute("contact", new Contact());

        return "home";
    }

    @PostMapping(path="/listing")
    public String save (@Valid @ModelAttribute("contact") Contact contact, BindingResult br, Model model) throws FileNotFoundException {
        //the @Valid is in front of the @ModelAttribute to validate contact
        // showcons should be a list of contacts saved
        if(br.hasErrors()) {
            return "home";
        } // this is to implement the validations from the model 

        List<Contact> contactList = contactRepo.save(contact); // returns contacts list from repo. need to pass in the new contact
        model.addAttribute("showcons", contactList);
        

        return "list";
    }

    @PostMapping(path="/delete/{email}")
    public String delete(@PathVariable("email") String email) {
        // contactRepo.delete(email);

        return "redirect:/list";
    }

    
}
