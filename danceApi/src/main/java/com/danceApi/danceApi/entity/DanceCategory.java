package com.danceapi.danceapi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DanceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour la catégorie de danse

    private String name; // Nom de la catégorie de danse

    @OneToMany(mappedBy = "danceCategory")
    private List<DanceSchool> danceSchools; // Liste des écoles de danse associées à cette catégorie

    @OneToMany(mappedBy = "danceCategory")
    private List<Course> courses; // Liste des cours associés à cette catégorie

    // Constructeur sans arguments
    public DanceCategory() {
    }

    // Getters et Setters
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

    public List<DanceSchool> getDanceSchools() {
        return danceSchools;
    }

    public void setDanceSchools(List<DanceSchool> danceSchools) {
        this.danceSchools = danceSchools;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}