// src/app/services/dance-category.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { DanceCategory } from '../models/dance-category';

@Injectable({
    providedIn: 'root'
})
export class DanceCategoryService {
    private apiUrl = 'http://localhost:8080/api/dance/categories'; // Remplacez par l'URL de votre API

    constructor(private http: HttpClient) {}

    // Récupérer toutes les catégories de danse
    getCategories(): Observable<DanceCategory[]> {
        return this.http.get<DanceCategory[]>(this.apiUrl).pipe(
            catchError(this.handleError) // Gestion des erreurs
        );
    }

    // Ajouter une nouvelle catégorie de danse
    addCategory(category: DanceCategory): Observable<DanceCategory> {
        // Vérifiez que l'objet category est valide avant d'envoyer la requête
        if (!category || !category.name) {
            return throwError('La catégorie doit avoir un nom valide.');
        }

        return this.http.post<DanceCategory>(this.apiUrl, category).pipe(
            catchError(this.handleError) // Gestion des erreurs
        );
    }

    // Mettre à jour une catégorie de danse existante
    updateCategory(id: number, category: DanceCategory): Observable<DanceCategory> {
        return this.http.put<DanceCategory>(`${this.apiUrl}/${id}`, category).pipe(
            catchError(this.handleError) // Gestion des erreurs
        );
    }

    // Supprimer une catégorie de danse
    deleteCategory(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
            catchError(this.handleError) // Gestion des erreurs
        );
    }

    // Méthode pour gérer les erreurs
    private handleError(error: any) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // Erreur côté client
            errorMessage = `Erreur: ${error.error.message}`;
        } else {
            // Erreur côté serveur
            errorMessage = `Code d'erreur: ${error.status}, Message: ${error.message}`;
        }
        console.error(errorMessage);
        return throwError(errorMessage); // Renvoie l'erreur pour être gérée dans le composant
    }
}