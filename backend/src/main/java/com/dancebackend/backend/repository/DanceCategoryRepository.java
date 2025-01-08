package com.dancebackend.backend.repository;

import com.dancebackend.backend.entity.DanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceCategoryRepository extends JpaRepository<DanceCategory, Long> {
}
