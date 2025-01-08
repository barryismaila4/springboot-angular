import { DanceSchool } from "./dance-school";

export class DanceCategory {
    constructor(
      public id: number,
      public name: string,
      public danceSchools?: DanceSchool[] // Optionnel, si vous souhaitez inclure les écoles de danse
    ) {}
  }