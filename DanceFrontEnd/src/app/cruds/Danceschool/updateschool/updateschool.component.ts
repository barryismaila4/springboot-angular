// src/app/cruds/Danceschool/updateschool/updateschool.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DanceSchoolService } from '../../../services/dance-school.service';
import { DanceSchool } from 'src/app/models/dance-school';
@Component({
  selector: 'app-updateschool',
  templateUrl: './updateschool.component.html',
  styleUrls: ['./updateschool.component.css']
})
export class UpdateschoolComponent implements OnInit {
  schoolForm!: FormGroup;
  schoolId!: number;

  constructor(
    private fb: FormBuilder,
    private danceSchoolService: DanceSchoolService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.schoolId = Number(this.route.snapshot.paramMap.get('id'));
    this.createForm();
    this.loadSchool();
  }

  createForm(): void {
    this.schoolForm = this.fb.group({
      name: ['', [Validators.required]],
      adresse: ['', [Validators.required]],
      horaire: ['', [Validators.required]],
      note: [null, [Validators.required, Validators.min(0), Validators.max(5)]]
    });
  }

  loadSchool(): void {
    this.danceSchoolService.getSchools().subscribe((schools) => {
      const school = schools.find(s => s.id === this.schoolId);
      if (school) {
        this.schoolForm.patchValue(school);
      }
    });
  }

  updateSchool(): void {
    if (this.schoolForm.invalid) {
      console.error('Le formulaire est invalide.');
      return;
    }

    const updatedSchool: DanceSchool = { id: this.schoolId, ...this.schoolForm.value };

    this.danceSchoolService.updateSchool(this.schoolId, updatedSchool).subscribe(
      () => {
        console.log('École mise à jour avec succès');
        this.router.navigate(['/main/schools']); // Rediriger vers la liste des écoles
      },
      (error) => {
        console.error('Erreur lors de la mise à jour de l\'école', error);
      }
    );
  }
}