package org.example.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "race")
public class Race {
    private int id;
    private String name;
    private List<Alien> aliens;

    public Race() {}

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "race", cascade = {CascadeType.ALL})
    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (this == o)
            return true;
        Race race = (Race) o;
        return id == race.id && name.equals(race.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
}
