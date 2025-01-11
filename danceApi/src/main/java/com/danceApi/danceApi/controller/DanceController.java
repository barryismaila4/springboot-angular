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
        try {
            DanceCategory createdCategory = danceService.addDanceCategory(danceCategory);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteDanceCategory(@PathVariable Long id) {
        try {
            danceService.deleteDanceCategory(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<DanceCategory> updateDanceCategory(@PathVariable Long id, @RequestBody DanceCategory danceCategory) {
        try {
            DanceCategory updatedCategory = danceService.updateDanceCategory(id, danceCategory);
            return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<DanceCategory>> listDanceCategories() {
        try {
            List<DanceCategory> categories = danceService.listDanceCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoints pour DanceSchool
    @PostMapping("/schools")
    public ResponseEntity<DanceSchool> addDanceSchool(@RequestBody DanceSchool danceSchool) {
        try {
            DanceSchool createdSchool = danceService.addDanceSchool(danceSchool);
            return new ResponseEntity<>(createdSchool, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteDanceSchool(@PathVariable Long id) {
        try {
            danceService.deleteDanceSchool(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/schools/{id}")
    public ResponseEntity<DanceSchool> updateDanceSchool(@PathVariable Long id, @RequestBody DanceSchool danceSchool) {
        try {
            DanceSchool updatedSchool = danceService.updateDanceSchool(id, danceSchool);
            return updatedSchool != null ? ResponseEntity.ok(updatedSchool) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/schools")
    public ResponseEntity<List<DanceSchool>> listDanceSchools() {
        try {
            List<DanceSchool> schools = danceService.listDanceSchools();
            return ResponseEntity.ok(schools);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoints pour Course
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        try {
            Course createdCourse = danceService.addCourse(course);
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
            danceService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        try {
            Course updatedCourse = danceService.updateCourse(id, course);
            return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> listCourses() {
        try {
            List<Course> courses = danceService.listCourses();
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
