package com.danceapi.danceapi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DanceSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour l'école de danse

    private String name; // Nom de l'école de danse
    private String address; // Adresse de l'école de danse
    private String openDay; // Jour d'ouverture
    private String closeDay; // Jour de fermeture
    private String openTime; // Heure d'ouverture
    private String closeTime; // Heure de fermeture

    @ManyToOne
    @JoinColumn(name = "dance_category_id")
    private DanceCategory danceCategory; // Référence à la catégorie de danse

    @OneToMany(mappedBy = "danceSchool")
    private List<Course> courses; // Liste des cours associés à cette école

    // Constructeur sans arguments
    public DanceSchool() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getCloseDay() {
        return closeDay;
    }

    public void setCloseDay(String closeDay) {
        this.closeDay = closeDay;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
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