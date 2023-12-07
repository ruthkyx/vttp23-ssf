package nus.iss.day18.day18lect.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<?> hello() { // ? means it can be any data type 
        try {
            return new ResponseEntity<>("hello! springboot is ok", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            // HttpStatus.INTERNAL_SERVER_ERROR is the same as returning error status code, js diff way of doing it
            return new ResponseEntity<>("Error running springboot!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("health")
    public ModelAndView getHealth() {
        ModelAndView mav = new ModelAndView();
        try {
            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(400));
        }
        return mav;
    }
}
