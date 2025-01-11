package com.danceapi.danceapi.repository;

import com.danceapi.danceapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByDanceSchoolId(Long danceSchoolId);
    List<Course> findByDanceCategoryId(Long danceCategoryId);
}
