package com.danceApi.danceApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;



import java.util.Set;

@Entity
@Table(name = "dance_school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanceSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String localisation;
    private String openTime;
    private String closeTime;

    @ManyToOne
    @JoinColumn(name = "dance_category_id")
    private DanceCategory danceCategory;

    @OneToMany(mappedBy = "danceSchool", cascade = CascadeType.ALL)
    private Set<Course> courses;
}