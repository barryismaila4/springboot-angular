package com.danceApi.danceApi.repository;


import com.danceApi.danceApi.entity.DanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceCategoryRepository extends JpaRepository<DanceCategory, Long> {
}
