package com.danceApi.danceApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String instructor;

    @Column(columnDefinition = "TEXT")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "dance_school_id", nullable = false)
    private DanceSchool danceSchool;
}
