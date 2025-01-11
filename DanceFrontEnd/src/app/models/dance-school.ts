import { Course } from "./course";
import { DanceCategory } from "./dance-category";



export interface DanceSchool {
    id: number;
    name: string;
    adresse: string;
    horaire: string;
    note: number;
    danceCategory?: DanceCategory; // Optionnel, car il peut ne pas être chargé
    courses?: Course[]; // Optionnel, car il peut ne pas être chargé
}