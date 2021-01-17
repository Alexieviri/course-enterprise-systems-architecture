package org.myspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/","/home"})
    public String mainPage(Model model){
        model.addAttribute("name","Home");
        return "home";
    }
}
