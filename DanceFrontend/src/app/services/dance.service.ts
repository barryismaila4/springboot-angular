import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../models/course';
import { DanceCategory } from '../models/dance-category';
import { DanceSchool } from '../models/dance-school';


@Injectable({
  providedIn: 'root',
})
export class DanceService {
  private apiUrl = 'http://localhost:8080/api'; // Remplacez par l'URL de votre API

  constructor(private http: HttpClient) {}

  // Méthodes pour DanceCategory
  getAllDanceCategories(): Observable<DanceCategory[]> {
    return this.http.get<DanceCategory[]>(`${this.apiUrl}/categories`);
  }

  getDanceCategoryById(id: number): Observable<DanceCategory> {
    return this.http.get<DanceCategory>(`${this.apiUrl}/categories/${id}`);
  }

  addDanceCategory(category: DanceCategory): Observable<DanceCategory> {
    return this.http.post<DanceCategory>(`${this.apiUrl}/categories`, category);
  }

  deleteDanceCategory(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/categories/${id}`);
  }

  // Méthodes pour DanceSchool
  getAllDanceSchools(): Observable<DanceSchool[]> {
    return this.http.get<DanceSchool[]>(`${this.apiUrl}/schools`);
  }

  getDanceSchoolById(id: number): Observable<DanceSchool> {
    return this.http.get<DanceSchool>(`${this.apiUrl}/schools/${id}`);
  }

  addDanceSchool(school: DanceSchool): Observable<DanceSchool> {
    return this.http.post<DanceSchool>(`${this.apiUrl}/schools`, school);
  }

  deleteDanceSchool(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/schools/${id}`);
  }

  // Méthodes pour Course
  getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.apiUrl}/courses`);
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/courses/${id}`);
  }

  addCourse(course: Course): Observable<Course> {
    return this.http.post<Course>(`${this.apiUrl}/courses`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/courses/${id}`);
  }
}