package com.davidlangheiter.tgm.daily_calculation.calculation;

import org.springframework.ui.Model;

public class Calculation {
    
    public final String name;
    public final String symbol;
    private final GenerateValues genValues;

    public Calculation(String name, String symbol, GenerateValues genValues) {
        this.name = name;
        this.symbol = symbol;
        this.genValues = genValues;
    }
    
    public Values generateValues(int max) {
        return genValues.generateValues(max);
    }
    
    public void applyToModel(Model model, Values values) {
        model.addAttribute("calcName", name);
        model.addAttribute("symbol", symbol);
        model.addAttribute("value1", values.value1);
        model.addAttribute("value2", values.value2);
    }
}
