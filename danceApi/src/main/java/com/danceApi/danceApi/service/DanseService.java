package com.danceApi.danceApi.service;

import com.danceApi.danceApi.entity.Course;
import com.danceApi.danceApi.entity.DanceCategory;
import com.danceApi.danceApi.entity.DanceSchool;
import com.danceApi.danceApi.repository.CourseRepository;
import com.danceApi.danceApi.repository.DanceCategoryRepository;
import com.danceApi.danceApi.repository.DanceSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanseService {

    @Autowired
    private DanceCategoryRepository danceCategoryRepository;

    @Autowired
    private DanceSchoolRepository danceSchoolRepository;

    @Autowired
    private CourseRepository courseRepository;

    // DanceCategory Methods
    public List<DanceCategory> getAllCategories() {
        return danceCategoryRepository.findAll();
    }

    public DanceCategory getCategoryById(Long id) {
        return danceCategoryRepository.findById(id).orElse(null);
    }

    public DanceCategory saveCategory(DanceCategory category) {
        return danceCategoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        danceCategoryRepository.deleteById(id);
    }

    // DanceSchool Methods
    public List<DanceSchool> getAllSchools() {
        return danceSchoolRepository.findAll();
    }

    public DanceSchool getSchoolById(Long id) {
        return danceSchoolRepository.findById(id).orElse(null);
    }

    public DanceSchool saveSchool(DanceSchool school) {
        return danceSchoolRepository.save(school);
    }

    public void deleteSchool(Long id) {
        danceSchoolRepository.deleteById(id);
    }

    // Course Methods
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}