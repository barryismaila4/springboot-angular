package com.danceapi.danceapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class DanceSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adresse;
    private String horaire;
    private Double note;

    @ManyToOne
    @JoinColumn(name = "dance_category_id")
    @JsonBackReference  // Ignorer cette référence lors de la sérialisation JSON
    private DanceCategory danceCategory;

    @OneToMany(mappedBy = "danceSchool")
    private List<Course> courses;

    // Constructeurs, getters, et setters
    public DanceSchool() {}

    public DanceSchool(Long id, String name, String adresse, String horaire, Double note, DanceCategory danceCategory, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.horaire = horaire;
        this.note = note;
        this.danceCategory = danceCategory;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public DanceCategory getDanceCategory() {
        return danceCategory;
    }

    public void setDanceCategory(DanceCategory danceCategory) {
        this.danceCategory = danceCategory;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
