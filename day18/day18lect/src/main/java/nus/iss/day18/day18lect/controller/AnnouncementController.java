package nus.iss.day18.day18lect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import nus.iss.day18.day18lect.model.Announcement;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {
    
    @GetMapping("/create")
    public String annoucementCreateForm(Model model) {
        model.addAttribute("announcement", new Announcement());
        return "annoucementCreate";
    }

    @PostMapping("/processAnnouncment")
    public String postAnnoucement(@Valid @ModelAttribute("annoucement") Announcement announcement, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "anouncementCreate";
        }
        model.addAttribute("showAnn", announcement);
        return "";
    }
}
