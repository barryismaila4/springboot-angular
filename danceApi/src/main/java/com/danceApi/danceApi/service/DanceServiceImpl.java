package com.danceapi.danceapi.service;

import com.danceapi.danceapi.entity.DanceCategory;
import com.danceapi.danceapi.entity.DanceSchool;
import com.danceapi.danceapi.entity.Course;
import com.danceapi.danceapi.repository.DanceCategoryRepository;
import com.danceapi.danceapi.repository.DanceSchoolRepository;
import com.danceapi.danceapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanceServiceImpl implements DanceService {

    private final DanceCategoryRepository danceCategoryRepository;
    private final DanceSchoolRepository danceSchoolRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DanceServiceImpl(DanceCategoryRepository danceCategoryRepository,
                            DanceSchoolRepository danceSchoolRepository,
                            CourseRepository courseRepository) {
        this.danceCategoryRepository = danceCategoryRepository;
        this.danceSchoolRepository = danceSchoolRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public DanceCategory addDanceCategory(DanceCategory danceCategory) {
        if (danceCategory.getDanceSchools() != null) {
            for (DanceSchool danceSchool : danceCategory.getDanceSchools()) {
                danceSchool.setDanceCategory(danceCategory);
            }
        }
        return danceCategoryRepository.save(danceCategory);
    }

    @Override
    public void deleteDanceCategory(Long id) {
        if (danceCategoryRepository.existsById(id)) {
            danceCategoryRepository.deleteById(id);
        }
    }

    @Override
    public DanceCategory updateDanceCategory(Long id, DanceCategory danceCategory) {
        if (danceCategoryRepository.existsById(id)) {
            danceCategory.setId(id);
            return danceCategoryRepository.save(danceCategory);
        }
        return null;
    }

    @Override
    public List<DanceCategory> listDanceCategories() {
        return danceCategoryRepository.findAll();
    }

    @Override
    public DanceSchool addDanceSchool(DanceSchool danceSchool) {
        return danceSchoolRepository.save(danceSchool);
    }

    @Override
    public void deleteDanceSchool(Long id) {
        if (danceSchoolRepository.existsById(id)) {
            danceSchoolRepository.deleteById(id);
        }
    }

    @Override
    public DanceSchool updateDanceSchool(Long id, DanceSchool danceSchool) {
        if (danceSchoolRepository.existsById(id)) {
            danceSchool.setId(id);
            return danceSchoolRepository.save(danceSchool);
        }
        return null;
    }

    @Override
    public List<DanceSchool> listDanceSchools() {
        return danceSchoolRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setId(id);
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }
}
