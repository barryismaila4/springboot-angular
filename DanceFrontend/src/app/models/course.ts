import { DanceSchool } from "./dance-school";

export class Course {
  constructor(
    public id: number,
    public title: string,
    public instructor: string,
    public contenu: string,
    public danceSchool: DanceSchool // Référence à l'école de danse
  ) {}
}