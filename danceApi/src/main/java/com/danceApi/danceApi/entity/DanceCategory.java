package com.danceapi.danceapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class DanceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "danceCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Sérialiser cette liste
    private List<DanceSchool> danceSchools;

    // Constructeurs, getters, et setters
    public DanceCategory() {}

    public DanceCategory(Long id, String name, List<DanceSchool> danceSchools) {
        this.id = id;
        this.name = name;
        this.danceSchools = danceSchools;
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

    public List<DanceSchool> getDanceSchools() {
        return danceSchools;
    }

    public void setDanceSchools(List<DanceSchool> danceSchools) {
        this.danceSchools = danceSchools;
    }
}
