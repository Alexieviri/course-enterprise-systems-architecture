package org.myspring.model;

import javax.persistence.*;

@Entity
@Table(schema="public",name="emails")
public class Email {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="email")
    private String email;

    @Column(name="condition")
    private String condition;

    @Override
    public String toString() {
        return "Email{" +
                "condition='" + condition + '\'' +
                '}';
    }

    public Email(){}

    public Email(String id, String condition) {
        this.id = id;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
