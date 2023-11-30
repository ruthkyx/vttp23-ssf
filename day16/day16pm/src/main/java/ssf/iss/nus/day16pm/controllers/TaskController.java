package ssf.iss.nus.day16pm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class TaskController {
    
    @PostMapping
    public String getTask() {

        return "task";
    }
 
}
