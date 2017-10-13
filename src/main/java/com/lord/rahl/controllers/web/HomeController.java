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

}
