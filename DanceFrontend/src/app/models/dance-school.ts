import { Course } from "./course";
import { DanceCategory } from "./dance-category";


export class DanceSchool {
  constructor(
    public id: number,
    public name: string,
    public localisation: string,
    public opentime: string,
    public closetime: string,
    public numero: string,
    public danceCategory: DanceCategory, // Référence à la catégorie de danse
    public courses?: Course[] // Optionnel, si vous souhaitez inclure les cours
  ) {}
}