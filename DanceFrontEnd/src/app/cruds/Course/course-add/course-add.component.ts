// src/app/cruds/Course/course-add/course-add.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CourseService } from '../../../services/course.service';
import { Course } from 'src/app/models/course';

@Component({
  selector: 'app-course-add',
  templateUrl: './course-add.component.html',
  styleUrls: ['./course-add.component.css']
})
export class CourseAddComponent implements OnInit {
  courseForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private courseService: CourseService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createForm();
  }

  createForm(): void {
    this.courseForm = this.fb.group({
      title: ['', [Validators.required]], // Titre du cours
      content: ['', [Validators.required]] // Contenu du cours
    });
  }

  addCourse(): void {
    if (this.courseForm.invalid) {
      console.error('Le formulaire est invalide.');
      return;
    }

    const course: Course = this.courseForm.value;

    this.courseService.addCourse(course).subscribe(
      (response) => {
        console.log('Cours ajouté avec succès', response);
        this.router.navigate(['/main/courses']); // Rediriger vers la liste des cours
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du cours', error);
      }
    );
  }
}