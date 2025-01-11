// src/app/services/course.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../models/course';



@Injectable({
    providedIn: 'root'
})
export class CourseService {
    private apiUrl = 'http://localhost:8080/api/dance/courses'; // Remplacez par l'URL de votre API

    constructor(private http: HttpClient) {}

    getCourses(): Observable<Course[]> {
        return this.http.get<Course[]>(this.apiUrl);
    }

    addCourse(course: Course): Observable<Course> {
        return this.http.post<Course>(this.apiUrl, course);
    }

    updateCourse(id: number, course: Course): Observable<Course> {
        return this.http.put<Course>(`${this.apiUrl}/${id}`, course);
    }

    deleteCourse(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}