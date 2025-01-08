package com.dancebackend.backend.repository;

import com.dancebackend.backend.entity.DanceSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceSchoolRepository extends JpaRepository<DanceSchool, Long> {
}
