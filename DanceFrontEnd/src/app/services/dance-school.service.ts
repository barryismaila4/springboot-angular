// src/app/services/dance-school.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DanceSchool } from '../models/dance-school';


@Injectable({
    providedIn: 'root'
})
export class DanceSchoolService {
    private apiUrl = 'http://localhost:8080/api/dance/schools'; // Remplacez par l'URL de votre API

    constructor(private http: HttpClient) {}

    getSchools(): Observable<DanceSchool[]> {
        return this.http.get<DanceSchool[]>(this.apiUrl);
    }

    addSchool(school: DanceSchool): Observable<DanceSchool> {
        return this.http.post<DanceSchool>(this.apiUrl, school);
    }

    updateSchool(id: number, school: DanceSchool): Observable<DanceSchool> {
        return this.http.put<DanceSchool>(`${this.apiUrl}/${id}`, school);
    }

    deleteSchool(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}