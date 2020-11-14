package com.cicd.calculator;

import com.cicd.calculator.domain.Calculator;
import com.cicd.calculator.domain.Inspriration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class InspirationController {
    @GetMapping("/quote")
    public String quoteForm(Model model) {
        Inspriration inspriration = new Inspriration();
        String quote = inspriration.Quote();
        model.addAttribute("quote", quote);
        return "quote";
    }
}
