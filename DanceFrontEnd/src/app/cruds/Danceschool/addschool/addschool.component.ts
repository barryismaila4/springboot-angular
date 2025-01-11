
// src/app/cruds/Danceschool/addschool/addschool.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DanceSchoolService } from '../../../services/dance-school.service';
import { DanceSchool } from 'src/app/models/dance-school';

@Component({
  selector: 'app-addschool',
  templateUrl: './addschool.component.html',
  styleUrls: ['./addschool.component.css']
})
export class AddschoolComponent implements OnInit {
  schoolForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private danceSchoolService: DanceSchoolService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createForm();
  }

  createForm(): void {
    this.schoolForm = this.fb.group({
      name: ['', [Validators.required]],
      adresse: ['', [Validators.required]],
      horaire: ['', [Validators.required]],
      note: [null, [Validators.required, Validators.min(0), Validators.max(5)]]
    });
  }

  addSchool(): void {
    if (this.schoolForm.invalid) {
      console.error('Le formulaire est invalide.');
      return;
    }

    const school: DanceSchool = this.schoolForm.value;

    this.danceSchoolService.addSchool(school).subscribe(
      (response) => {
        console.log('École ajoutée avec succès', response);
        this.router.navigate(['/main/schools']); // Rediriger vers la liste des écoles
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'école', error);
      }
    );
  }
}