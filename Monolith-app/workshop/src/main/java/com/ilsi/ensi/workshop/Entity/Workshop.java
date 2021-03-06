package com.ilsi.ensi.workshop.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @NotNull
    @Column(name="title")
    private String title;


    @Column(name="description")
    private String description;



    @NotNull
    @Column(name = "field")
    private String field;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCenter", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Workshop_Center workshop_Center;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCard", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trainer trainer;

    public Workshop() {
        //Jpa
    }

    public Workshop(String title, String description, String field, Workshop_Center workshop_Center, Trainer trainer) {
        this.title = title;
        this.description = description;
        this.field = field;
        this.workshop_Center = workshop_Center;
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Workshop_Center getWorkshop_Center() {
        return workshop_Center;
    }

    public void setWorkshop_Center(Workshop_Center workshop_Center) {
        this.workshop_Center = workshop_Center;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workshop workshop = (Workshop) o;
        return Objects.equals(id, workshop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Workshop{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", field='" + field + '\'' +
                ", workshop_Center=" + workshop_Center +
                ", trainer=" + trainer +
                '}';
    }
}
