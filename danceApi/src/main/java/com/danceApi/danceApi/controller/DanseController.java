package com.danceApi.danceApi.controller;

import com.danceApi.danceApi.entity.Course;
import com.danceApi.danceApi.entity.DanceCategory;
import com.danceApi.danceApi.entity.DanceSchool;
import com.danceApi.danceApi.service.DanseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dance")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser les requêtes CORS depuis l'origine spécifiée
public class DanseController {

    @Autowired
    private DanseService danseService;

    // DanceCategory Endpoints
    @GetMapping("/categories")
    public List<DanceCategory> getAllCategories() {
        return danseService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<DanceCategory> getCategoryById(@PathVariable Long id) {
        DanceCategory category = danseService.getCategoryById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping("/categories")
    public DanceCategory createCategory(@RequestBody DanceCategory category) {
        return danseService.saveCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        danseService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // DanceSchool Endpoints
    @GetMapping("/schools")
    public List<DanceSchool> getAllSchools() {
        return danseService.getAllSchools();
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<DanceSchool> getSchoolById(@PathVariable Long id) {
        DanceSchool school = danseService.getSchoolById(id);
        return school != null ? ResponseEntity.ok(school) : ResponseEntity.notFound().build();
    }

    @PostMapping("/schools")
    public DanceSchool createSchool(@RequestBody DanceSchool school) {
        return danseService.saveSchool(school);
    }

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        danseService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }

    // Course Endpoints
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return danseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = danseService.getCourseById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return danseService.saveCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        danseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}