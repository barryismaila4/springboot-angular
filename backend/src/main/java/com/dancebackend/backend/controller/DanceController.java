package com.dancebackend.backend.controller;

import com.dancebackend.backend.entity.DanceCategory;
import com.dancebackend.backend.entity.DanceSchool;
import com.dancebackend.backend.entity.Course;
import com.dancebackend.backend.service.DanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DanceController {

    private final DanceService danceService;

    @Autowired
    public DanceController(DanceService danceService) {
        this.danceService = danceService;
    }

    // Endpoints pour DanceCategory
    @GetMapping("/categories")
    public List<DanceCategory> getAllDanceCategories() {
        return danceService.listAllDanceCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<DanceCategory> getDanceCategoryById(@PathVariable Long id) {
        return danceService.getDanceCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/categories")
    public DanceCategory addDanceCategory(@RequestBody DanceCategory category) {
        return danceService.addDanceCategory(category);
    }

   /* @PutMapping("/categories/{id}")
    public ResponseEntity<DanceCategory> updateDanceCategory(@PathVariable Long id, @RequestBody DanceCategory categoryDetails) {
        DanceCategory updatedCategory = danceService.updateDanceCategory(id, categoryDetails);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteDanceCategory(@PathVariable Long id) {
        danceService.deleteDanceCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour DanceSchool
    @GetMapping("/schools")
    public List<DanceSchool> getAllDanceSchools() {
        return danceService.listAllDanceSchools();
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<DanceSchool> getDanceSchoolById(@PathVariable Long id) {
        return danceService.getDanceSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/schools")
    public DanceSchool addDanceSchool(@RequestBody DanceSchool school) {
        return danceService.addDanceSchool(school);
    }

   /* @PutMapping("/schools/{id}")
    public ResponseEntity<DanceSchool> updateDanceSchool(@PathVariable Long id, @RequestBody DanceSchool schoolDetails) {
        DanceSchool updatedSchool = danceService.updateDanceSchool(id, schoolDetails);
        return updatedSchool != null ? ResponseEntity.ok(updatedSchool) : ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteDanceSchool(@PathVariable Long id) {
        danceService.deleteDanceSchool(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour Course
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return danceService.listAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return danceService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return danceService.addCourse(course);
    }

    /* @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        Course updatedCourse = danceService.updateCourse(id, courseDetails);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        danceService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
