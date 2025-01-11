import { Course } from "./course";
import { DanceSchool } from "./dance-school";

export interface DanceCategory {
  id: number;
  name: string;
  danceSchools?: DanceSchool[]; // Optionnel
  courses?: Course[]; // Optionnel
}
