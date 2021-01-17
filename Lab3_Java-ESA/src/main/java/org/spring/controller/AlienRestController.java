package org.spring.controller;

import org.spring.model.Alien;
import org.spring.model.AlienXMLList;
import org.spring.repo.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aliens/")
public class AlienRestController {

    @Autowired
    AlienRepository alienRepository;

    @GetMapping(value = "/v1")
    public Iterable<Alien> getAllAliens(){
        return this.alienRepository.findAll();
    }

    @GetMapping(value = "/v2")
    public AlienXMLList getAllAliensXML(){
        Iterable<Alien> alienIterable = this.alienRepository.findAll();
        List<Alien> alienList = new ArrayList<>();
        alienIterable.forEach(alienList::add);
        return new AlienXMLList(alienList);
    }

    @PostMapping(value = "/v1/add")
    public String addAlien(@ModelAttribute("alien") Alien a){
        alienRepository.save(a);
        return "alien";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeAlien(@PathVariable("id") int id){
        Alien alien = this.alienRepository.findById(id).orElse(null);
        if(alien == null)
            return null;
        this.alienRepository.delete(alien);
        return "race";
    }

}
