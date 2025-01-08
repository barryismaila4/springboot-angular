package com.danceApi.danceApi.repository;

import com.danceApi.danceApi.entity.DanceSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceSchoolRepository extends JpaRepository<DanceSchool, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}