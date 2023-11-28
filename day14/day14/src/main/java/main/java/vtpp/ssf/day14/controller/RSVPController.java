package main.java.vtpp.ssf.day14.controller;

import org.springframework.http.HttpStatusCode;
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
@RequestMapping(path = "/rsvp")
public class RSVPController {
    // RSVP by GET
    @GetMapping
    public String getRSVP(@RequestParam MultiValueMap<String, String> form, @RequestParam String name, Model model) {
        System.out.printf("map%s\n", form);
        System.out.printf("map%s\n", name);

        // model.addAttribute("name", name);
        model.addAttribute("name", form.getFirst("name"));

        return "thankyou";
    }

    // RSVP by POST
    @PostMapping
    public ModelAndView postRSVP(@RequestBody MultiValueMap<String, String> form) {
        System.out.printf("map post: %s\n" , form);
        String name = form.getFirst("name").trim().toLowerCase();
        // this mav obj can control how resonse is returned 
        ModelAndView mav = new ModelAndView("thankyou");
        if(!"fred".equals(name)) {
            mav.setViewName("whoareyou");
            mav.setStatus(HttpStatusCode.valueOf(400));
        } else {
            mav.setViewName("thankyou");
            mav.setStatus(HttpStatusCode.valueOf(201));
        }

        mav.addObject("name", form.getFirst("name"));
        return mav;
    }
}
