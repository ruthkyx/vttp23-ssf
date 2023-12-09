package classworkshop.ssf.day14RSVP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/rsvp")
public class RSVPcontroller {
    
    @GetMapping
    public String getRSVP(@RequestParam MultiValueMap<String, String> form,
    @RequestParam String name, Model model) {

        model.addAttribute("name", form.getFirst("name"));
        return "thankyou";
    }

    @PostMapping
    public ModelAndView postRSVP(@RequestBody MultiValueMap<String, String> form) {
        ModelAndView mav = new ModelAndView();
        String name = form.getFirst("name").trim().toLowerCase();
        mav.setViewName("thankyou");
        mav.addObject("name", name);

        return mav;
    }

}
