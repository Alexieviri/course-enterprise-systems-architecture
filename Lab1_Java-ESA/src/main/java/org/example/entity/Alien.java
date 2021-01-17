package org.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "alien")
public class Alien {
    private int id;
    private String fullName;
    private Race race;
    private boolean alive;

    public Alien(){}

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "fullname", nullable = false, length = 30)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "race_id")
    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Column(name = "alive", nullable = false)
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (this == o)
            return true;
        Alien alien = (Alien) o;
        return id == alien.id
                && fullName.equals(alien.fullName)
                && alive == alien.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, alive);
    }

}
