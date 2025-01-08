package com.danceApi.danceApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Table(name = "dance_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "danceCategory", cascade = CascadeType.ALL)
    private Set<DanceSchool> danceSchools;
}