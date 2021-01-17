package org.myspring.controller;

import org.myspring.jms.JmsSender;
import org.myspring.model.Email;
import org.myspring.model.Race;
import org.myspring.model.RaceXMLList;
import org.myspring.repo.RaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/races/")
public class RaceRestController {

    private final JmsSender jmsSender;
    private final RaceRepository raceRepository;


    RaceRestController(JmsSender jmsSender, RaceRepository raceRepository){
        this.jmsSender = jmsSender;
        this.raceRepository = raceRepository;
    }

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
        Race race = this.raceRepository.findById(r.getId()).orElse(null);
        if(race == null){
            jmsSender.sendObjectUpdate(r,"CREATE");
            Email email = new Email(UUID.randomUUID().toString(),"CREATE");
            jmsSender.sendEmail(email);
        }
        else{
            jmsSender.sendObjectUpdate(race,"UPDATE");
            Email email = new Email(UUID.randomUUID().toString(),"UPDATE");
            jmsSender.sendEmail(email);
        }
        raceRepository.save(r);
        return "race";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeRace(@PathVariable("id") int id){
        Race race = this.raceRepository.findById(id).orElse(null);
        if(race == null)
            return null;
        jmsSender.sendObjectUpdate(race,"REMOVE");
        Email email = new Email(UUID.randomUUID().toString(),"REMOVE");
        jmsSender.sendEmail(email);
        this.raceRepository.delete(race);
        return "race";
    }

}
