package com.lord.rahl.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/denied")
    public String denied(){
        return "denied";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
