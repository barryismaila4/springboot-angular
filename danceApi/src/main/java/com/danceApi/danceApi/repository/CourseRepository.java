package com.danceApi.danceApi.repository;

import com.danceApi.danceApi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}