package sg.edu.nus.iss.day12workshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class NumberController {
    
    @GetMapping(path ="/")
    public String home() {
        return "generator";
    }

    @GetMapping(path= "/result")
    public String generateNumbers(@RequestParam int count, Model model) {
        List<Integer> numbersList = generateRandomNumbers(count);
        model.addAttribute("numbers", numbersList);
        model.addAttribute("text", "some text");

        return "result"; 
    }

    public List<Integer> generateRandomNumbers (int count) {
        
        List<Integer> numbers = new ArrayList<>();
        // to generate the random number
        Random rand = new Random();

        for(int i = 0; i < count; i++) {
              numbers.add(rand.nextInt(30)+1);
        }

        return numbers;
    }
}
