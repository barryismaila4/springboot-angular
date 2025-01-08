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
import java.util.Optional;

@Service
public class DanceService {

    private final DanceCategoryRepository danceCategoryRepository;
    private final DanceSchoolRepository danceSchoolRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DanceService(DanceCategoryRepository danceCategoryRepository,
                        DanceSchoolRepository danceSchoolRepository,
                        CourseRepository courseRepository) {
        this.danceCategoryRepository = danceCategoryRepository;
        this.danceSchoolRepository = danceSchoolRepository;
        this.courseRepository = courseRepository;
    }

    // CRUD for DanceCategory
    public List<DanceCategory> listAllDanceCategories() {
        return danceCategoryRepository.findAll();
    }

    public Optional<DanceCategory> getDanceCategoryById(Long id) {
        return danceCategoryRepository.findById(id);
    }

    public DanceCategory addDanceCategory(DanceCategory category) {
        return danceCategoryRepository.save(category);
    }

   /* public DanceCategory updateDanceCategory(Long id, DanceCategory categoryDetails) {
        return danceCategoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDetails.getName());
                    return danceCategoryRepository.save(category);
                })
                .orElse(null);
    }*/

    public void deleteDanceCategory(Long id) {
        danceCategoryRepository.deleteById(id);
    }

    // CRUD for DanceSchool
    public List<DanceSchool> listAllDanceSchools() {
        return danceSchoolRepository.findAll();
    }

    public Optional<DanceSchool> getDanceSchoolById(Long id) {
        return danceSchoolRepository.findById(id);
    }

    public DanceSchool addDanceSchool(DanceSchool school) {
        return danceSchoolRepository.save(school);
    }

   /* public DanceSchool updateDanceSchool(Long id, DanceSchool schoolDetails) {
        return danceSchoolRepository.findById(id)
                .map(school -> {
                    school.setName(schoolDetails.getName());
                    school.setLocalisation(schoolDetails.getLocalisation());
                    school.setOpentime(schoolDetails.getOpentime());
                    school.setClosetime(schoolDetails.getClosetime());
                    school.setNumero(schoolDetails.getNumero());
                    return danceSchoolRepository.save(school);
                })
                .orElse(null);
    }*/

    public void deleteDanceSchool(Long id) {
        danceSchoolRepository.deleteById(id);
    }

    // CRUD for Course
    public List<Course> listAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

   /* public Course updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(courseDetails.getTitle());
                    course.setInstructor(courseDetails.getInstructor());
                    course.setContenu(courseDetails.getContenu());
                    return courseRepository.save(course);
                })
                .orElse(null);
    }*/

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
