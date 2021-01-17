package org.myspring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="aliens")
public class AlienXMLList {
    @XmlElement
    List<Alien> alien = new ArrayList<>();

    public AlienXMLList(){}

    public AlienXMLList(List<Alien> aliens){this.alien = aliens;}

    public List<Alien> getAllAliens(){return this.alien;}
}
