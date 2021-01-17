package org.myspring.controller;


import org.myspring.jms.JmsSender;
import org.myspring.model.Alien;
import org.myspring.model.AlienXMLList;
import org.myspring.model.Email;
import org.myspring.repo.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aliens/")
public class AlienRestController {

    private final JmsSender jmsSender;
    private final AlienRepository alienRepository;

    @Autowired
    public AlienRestController(JmsSender jmsSender, AlienRepository alienRepository) {
        this.jmsSender = jmsSender;
        this.alienRepository = alienRepository;
    }

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
        Alien alien = this.alienRepository.findById(a.getId()).orElse(null);
        if(alien == null){
            jmsSender.sendObjectUpdate(a,"CREATE");
            Email email = new Email(UUID.randomUUID().toString(),"CREATE");
            jmsSender.sendEmail(email);
        }
        else {
            jmsSender.sendObjectUpdate(alien, "UPDATE");
            if(alien.isAlive() && !a.isAlive()){
                Email email = new Email(UUID.randomUUID().toString(),"KILL");
                jmsSender.sendEmail(email);
            }
            if(alien.getRace() != a.getRace()) {
                Email email = new Email(UUID.randomUUID().toString(),"KILL");
                jmsSender.sendEmail(email);
            }
        }
        alienRepository.save(a);

        return "alien";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeAlien(@PathVariable("id") int id){
        Alien alien = this.alienRepository.findById(id).orElse(null);
        if(alien == null)
            return null;
        jmsSender.sendObjectUpdate(alien,"REMOVE");
        Email email = new Email(UUID.randomUUID().toString(),"REMOVE");
        jmsSender.sendEmail(email);
        this.alienRepository.delete(alien);
        return "race";
    }

}
