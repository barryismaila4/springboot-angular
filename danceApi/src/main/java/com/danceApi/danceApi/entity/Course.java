package com.danceapi.danceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "dance_category_id")
    @JsonIgnore  // Ignorer la référence à DanceCategory lors de la sérialisation JSON
    private DanceCategory danceCategory;

    @ManyToOne
    @JoinColumn(name = "dance_school_id")
    @JsonIgnore  // Ignorer la référence à DanceSchool lors de la sérialisation JSON
    private DanceSchool danceSchool;

    // Constructeurs, getters, et setters
    public Course() {}

    public Course(Long id, String title, String content, DanceCategory danceCategory, DanceSchool danceSchool) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.danceCategory = danceCategory;
        this.danceSchool = danceSchool;
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
