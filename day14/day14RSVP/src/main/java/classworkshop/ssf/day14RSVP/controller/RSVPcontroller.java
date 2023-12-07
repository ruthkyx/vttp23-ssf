package classworkshop.ssf.day14RSVP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/rsvp")
public class RSVPcontroller {
    
    @GetMapping
    public String getRSVP(Model model) {
        model.addAttribute("name", );
        return "thankyou";
    }

    @PostMapping
    public ModelAndView postRSVP(Model model) {
        ModelAndView mav = new ModelAndView();

        return mav;
    }

}
