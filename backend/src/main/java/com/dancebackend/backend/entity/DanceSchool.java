package com.dancebackend.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanceSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String localisation;

    private String opentime;

    private String closetime;

    @Column(nullable = false, unique = true)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "dance_category_id", nullable = false)
    private DanceCategory danceCategory;

    @OneToMany(mappedBy = "danceSchool", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;
}
