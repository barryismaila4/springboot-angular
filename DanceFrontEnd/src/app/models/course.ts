import { DanceCategory } from "./dance-category";
import { DanceSchool } from "./dance-school";



export interface Course {
    id: number;
    title: string;
    content: string;
    danceCategory?: DanceCategory; // Optionnel, car il peut ne pas être chargé
    danceSchool?: DanceSchool; // Optionnel, car il peut ne pas être chargé
}