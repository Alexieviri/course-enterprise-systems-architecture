package org.spring.controller;

import org.spring.model.Alien;
import org.spring.model.AlienXMLList;
import org.spring.model.Race;
import org.spring.model.RaceXMLList;
import org.spring.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/races/")
public class RaceRestController {

    @Autowired
    RaceRepository raceRepository;

    @GetMapping(value = "/v1")
    public Iterable<Race> getAllRaces(){
        return this.raceRepository.findAll();
    }

    @GetMapping(value = "/v2")
    public RaceXMLList getAllRacesXML(){
        Iterable<Race> raceIterable = this.raceRepository.findAll();
        List<Race> raceList = new ArrayList<>();
        raceIterable.forEach(raceList::add);
        return new RaceXMLList(raceList);
    }

    @PostMapping(value = "/v1/add")
    public String addRace(@ModelAttribute("race") Race r){
        raceRepository.save(r);
        return "race";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeRace(@PathVariable("id") int id){
        Race race = this.raceRepository.findById(id).orElse(null);
        if(race == null)
            return null;
        this.raceRepository.delete(race);
        return "race";
    }

}
