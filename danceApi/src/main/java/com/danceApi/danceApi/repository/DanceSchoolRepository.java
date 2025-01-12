package com.danceapi.danceapi.repository;

import com.danceapi.danceapi.entity.DanceSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanceSchoolRepository extends JpaRepository<DanceSchool, Long> {
    List<DanceSchool> findByDanceCategoryId(Long danceCategoryId);
    // Vous pouvez ajouter d'autres méthodes personnalisées ici si nécessaire
}