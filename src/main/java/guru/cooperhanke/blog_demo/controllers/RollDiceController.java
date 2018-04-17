package guru.cooperhanke.blog_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String showResults(@PathVariable int guess, Model model) {
        model.addAttribute("guess", guess);
        int target = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        model.addAttribute("target", target);
        boolean correct;
        correct = target == guess;
        model.addAttribute("correct", correct);
        return "results";
    }
}
