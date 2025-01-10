package com.danceapi.danceapi.entity;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour le cours

    private String title; // Titre du cours

    @Lob // Indique que ce champ peut contenir une grande quantité de données
    private String content; // Contenu du cours

    @ManyToOne
    @JoinColumn(name = "dance_category_id")
    private DanceCategory danceCategory; // Référence à la catégorie de danse

    @ManyToOne
    @JoinColumn(name = "dance_school_id")
    private DanceSchool danceSchool; // Référence à l'école de danse

    // Constructeur sans arguments
    public Course() {
    }

    // Getters et Setters
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DanceCategory getDanceCategory() {
        return danceCategory;
    }

    public void setDanceCategory(DanceCategory danceCategory) {
        this.danceCategory = danceCategory;
    }

    public DanceSchool getDanceSchool() {
        return danceSchool;
    }

    public void setDanceSchool(DanceSchool danceSchool) {
        this.danceSchool = danceSchool;
    }
}