package com.Bank.BRBNMPL.controller;

import com.Bank.BRBNMPL.entity.BankGuarantee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping("/brbnmpl")
    public String homePage() {
        return "home";
    }
    @GetMapping("/register-bg")
    public String showBgForm() {
        return "guarantee-form";
    }
    @GetMapping("/view-bg")
    public String getBgDetails() {return "view";}
    @GetMapping("/bg-edit-options")
    public String getEditFunctionalities() {return "edit-options";}
    @GetMapping("/bg-amendment")
    public String getAmendmentForm(){return "amendment";}
    @GetMapping("/bg-closure")
    public String getClosureForm(){return "closure";}
}
