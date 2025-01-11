// src/app/models/course.ts
import { DanceCategory } from "./dance-category";
import { DanceSchool } from "./dance-school";

export interface Course {
    id: number; // Utilisez 'number' pour correspondre à Long en Java
    title: string; // Titre du cours
    content: string; // Contenu du cours
    danceCategory?: DanceCategory; // Optionnel, car il peut ne pas être chargé
    danceSchool?: DanceSchool; // Optionnel, car il peut ne pas être chargé
}