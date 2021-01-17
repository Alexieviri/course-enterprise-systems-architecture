package org.myspring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "races")
public class RaceXMLList {
    @XmlElement
    List<Race> race = new ArrayList<>();

    public RaceXMLList() {
    }

    public RaceXMLList(List<Race> races) { this.race = races;}

    public List<Race> getAllRaces() { return race; }
}
