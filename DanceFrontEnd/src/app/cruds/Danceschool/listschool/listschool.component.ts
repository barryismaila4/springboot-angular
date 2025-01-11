// src/app/cruds/Danceschool/listschool/listschool.component.ts
import { Component, OnInit } from '@angular/core';
import { DanceSchoolService } from '../../../services/dance-school.service';
import { DanceSchool } from 'src/app/models/dance-school';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listschool',
  templateUrl: './listschool.component.html',
  styleUrls: ['./listschool.component.css']
})
export class ListschoolComponent implements OnInit {
  schools: DanceSchool[] = [];

  constructor(private danceSchoolService: DanceSchoolService, private router: Router) {}

  ngOnInit(): void {
    this.loadSchools();
  }

  loadSchools(): void {
    this.danceSchoolService.getSchools().subscribe(
      (data) => {
        this.schools = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des écoles', error);
      }
    );
  }

  editSchool(id: number): void {
    this.router.navigate(['/main/schools/update', id]);
  }

  deleteSchool(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette école ?')) {
      this.danceSchoolService.deleteSchool(id).subscribe(
        () => {
          this.loadSchools(); // Recharger la liste après la suppression
          console.log('École supprimée avec succès');
        },
        (error) => {
          console.error('Erreur lors de la suppression de l\'école', error);
        }
      );
    }
  }
}