package com.davidlangheiter.tgm.daily_calculation;

import com.davidlangheiter.tgm.daily_calculation.calculation.Calculation;
import com.davidlangheiter.tgm.daily_calculation.calculation.Values;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Random;

@Controller
public class Web {

    static final HashMap<String, Calculation> calculations = new HashMap<>();

    static final Random random = new Random();

    static {
        calculations.put("add", new Calculation(
                "Addition",
                "+",
                max -> new Values(random.nextInt(max), random.nextInt(max))
        ));
        calculations.put("sub", new Calculation(
                "Subtraction",
                "-",
                max -> new Values(random.nextInt(max), random.nextInt(max))
        ));
        calculations.put("mul", new Calculation(
                "Multiplikation",
                "*",
                max -> new Values(random.nextInt(max), random.nextInt(max))
        ));
        calculations.put("div", new Calculation(
                "Division",
                "/",
                max -> {
                    int v1 = random.nextInt(max);
                    return new Values(v1, random.nextInt(v1 / 2));
                })
        );
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
    
    @GetMapping("/{calc}")
    public String addition(Model model, @PathVariable("calc") String calc , @RequestParam("max") int maxVal) {
        Calculation c = calculations.get(calc);
        if(c == null) {
            throw new NotFoundException();
        }
        c.applyToModel(model, c.generateValues(maxVal));
        return "calc";
    }

}
