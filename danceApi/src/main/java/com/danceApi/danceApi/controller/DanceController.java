package com.danceapi.danceapi.controller;

import com.danceapi.danceapi.entity.DanceCategory;
import com.danceapi.danceapi.entity.DanceSchool;
import com.danceapi.danceapi.entity.Course;
import com.danceapi.danceapi.service.DanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dance")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser les requêtes CORS depuis Angular
public class DanceController {

    private final DanceService danceService;

    @Autowired
    public DanceController(DanceService danceService) {
        this.danceService = danceService;
    }

    // Endpoints pour DanceCategory
    @PostMapping("/categories")
    public ResponseEntity<DanceCategory> addDanceCategory(@RequestBody DanceCategory danceCategory) {
        DanceCategory createdCategory = danceService.addDanceCategory(danceCategory);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteDanceCategory(@PathVariable Long id) {
        danceService.deleteDanceCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<DanceCategory> updateDanceCategory(@PathVariable Long id, @RequestBody DanceCategory danceCategory) {
        DanceCategory updatedCategory = danceService.updateDanceCategory(id, danceCategory);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<List<DanceCategory>> listDanceCategories() {
        List<DanceCategory> categories = danceService.listDanceCategories();
        return ResponseEntity.ok(categories);
    }

    // Endpoints pour DanceSchool
    @PostMapping("/schools")
    public ResponseEntity<DanceSchool> addDanceSchool(@RequestBody DanceSchool danceSchool) {
        DanceSchool createdSchool = danceService.addDanceSchool(danceSchool);
        return new ResponseEntity<>(createdSchool, HttpStatus.CREATED);
    }

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteDanceSchool(@PathVariable Long id) {
        danceService.deleteDanceSchool(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/schools/{id}")
    public ResponseEntity<DanceSchool> updateDanceSchool(@PathVariable Long id, @RequestBody DanceSchool danceSchool) {
        DanceSchool updatedSchool = danceService.updateDanceSchool(id, danceSchool);
        return updatedSchool != null ? ResponseEntity.ok(updatedSchool) : ResponseEntity.notFound().build();
    }

    @GetMapping("/schools")
    public ResponseEntity<List<DanceSchool>> listDanceSchools() {
        List<DanceSchool> schools = danceService.listDanceSchools();
        return ResponseEntity.ok(schools);
    }

    // Endpoints pour Course
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course createdCourse = danceService.addCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        danceService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = danceService.updateCourse(id, course);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> listCourses() {
        List<Course> courses = danceService.listCourses();
        return ResponseEntity.ok(courses);
    }
}