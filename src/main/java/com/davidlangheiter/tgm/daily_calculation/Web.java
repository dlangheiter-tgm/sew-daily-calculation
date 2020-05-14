package com.davidlangheiter.tgm.daily_calculation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class Web {
    
    static final Random random = new Random();
    
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
    
    @GetMapping("/add")
    public String add(Model model, @RequestParam("max") int maxVal) {
        int val1 = random.nextInt(maxVal);
        int val2 = random.nextInt(maxVal);
        model.addAttribute("calcName", "Addition");
        model.addAttribute("calc", val1 + " + " + val2);
        return "calc";
    }

    @GetMapping("/sub")
    public String sub(Model model, @RequestParam("max") int maxVal) {
        int val1 = random.nextInt(maxVal);
        int val2 = random.nextInt(maxVal);
        model.addAttribute("calcName", "Subtraktion");
        model.addAttribute("calc", val1 + " - " + val2);
        return "calc";
    }

    @GetMapping("/mul")
    public String mul(Model model, @RequestParam("max") int maxVal) {
        int val1 = random.nextInt(maxVal);
        int val2 = random.nextInt(maxVal);
        model.addAttribute("calcName", "Multiplikation");
        model.addAttribute("calc", val1 + " * " + val2);
        return "calc";
    }

    @GetMapping("/div")
    public String addition(Model model, @RequestParam("max") int maxVal) {
        int val1 = random.nextInt(maxVal);
        int val2 = random.nextInt(val1/2);
        model.addAttribute("calcName", "Division");
        model.addAttribute("calc", val1 + " / " + val2);
        return "calc";
    }
    
}
