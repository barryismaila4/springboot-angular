package com.danceapi.danceapi.service;

import com.danceapi.danceapi.entity.DanceCategory;
import com.danceapi.danceapi.entity.DanceSchool;
import com.danceapi.danceapi.entity.Course;

import java.util.List;

public interface DanceService {

    // Méthodes pour DanceCategory
    DanceCategory addDanceCategory(DanceCategory danceCategory);
    void deleteDanceCategory(Long id);
    DanceCategory updateDanceCategory(Long id, DanceCategory danceCategory);
    List<DanceCategory> listDanceCategories();

    // Méthodes pour DanceSchool
    DanceSchool addDanceSchool(DanceSchool danceSchool);
    void deleteDanceSchool(Long id);
    DanceSchool updateDanceSchool(Long id, DanceSchool danceSchool);
    List<DanceSchool> listDanceSchools();

    // Méthodes pour Course
    Course addCourse(Course course);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course course);
    List<Course> listCourses();
}
