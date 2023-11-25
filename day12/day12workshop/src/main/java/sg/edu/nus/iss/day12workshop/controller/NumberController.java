package sg.edu.nus.iss.day12workshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumberController {
    
    @GetMapping(path="/generateNumbers/")
    public String generateNumbers(@PathVariable int count, Model model) {
        List<Integer> numbers = generateRandomNumbers(count);
        model.addAttribute("numbers", numbers);

        return "numberList"; // thymeleaf template name
    }

    public List<Integer> generateRandomNumbers (int count) {
        
        List<Integer> numbers = new ArrayList<>();
        // to generate the random number
        Random rand = new Random();

        for(int i = 0; i < count; i++) {
            int randomNumber;
            do {
                randomNumber = rand.nextInt(30)+1;
            } while (numbers.contains(randomNumber));
             numbers.add(randomNumber);
        }

        return numbers;
    }
}
