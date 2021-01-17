package org.spring.controller;

import org.spring.model.Race;
import org.spring.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @RequestMapping(value = "/races", method = RequestMethod.GET)
    public Iterable<Race> getAllRaces(Model model) {
        Iterable<Race> races = this.raceRepository.findAll();
        model.addAttribute("races",races);
        return races;
    }
}
