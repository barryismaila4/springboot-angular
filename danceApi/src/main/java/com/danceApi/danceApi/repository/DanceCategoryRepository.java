package com.danceapi.danceapi.repository;

import com.danceapi.danceapi.entity.DanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceCategoryRepository extends JpaRepository<DanceCategory, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}