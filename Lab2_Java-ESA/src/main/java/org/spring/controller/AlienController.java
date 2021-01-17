package org.spring.controller;

import org.spring.model.Alien;
import org.spring.repo.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlienController {

    @Autowired
    AlienRepository alienRepository;

    @RequestMapping(value = "/aliens",method = RequestMethod.GET)
    public Iterable<Alien> getAllAliens(Model model){
        Iterable<Alien> aliens = this.alienRepository.findAll();
        model.addAttribute("aliens",aliens);
        return aliens;
    }
}
