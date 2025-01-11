// src/app/cruds/Course/course-update/course-update.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../../../services/course.service';
import { Course } from 'src/app/models/course';

@Component({
  selector: 'app-course-update',
  templateUrl: './course-update.component.html',
  styleUrls: ['./course-update.component.css']
})
export class CourseUpdateComponent implements OnInit {
  courseForm!: FormGroup;
  courseId!: number;
  courses: Course[] = []; // Pour stocker tous les cours

  constructor(
    private fb: FormBuilder,
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.courseId = Number(this.route.snapshot.paramMap.get('id'));
    this.createForm();
    this.loadCourses(); // Charger tous les cours
  }

  createForm(): void {
    this.courseForm = this.fb.group({
      title: ['', [Validators.required]],
      content: ['', [Validators.required]]
    });
  }

  loadCourses(): void {
    this.courseService.getCourses().subscribe(
      (data) => {
        this.courses = data;
        this.setCourseData(); // Appeler la méthode pour définir les données du cours
      },
      (error) => {
        console.error('Erreur lors du chargement des cours', error);
      }
    );
  }

  setCourseData(): void {
    const course = this.courses.find(c => c.id === this.courseId); // Trouver le cours par ID
    if (course) {
      this.courseForm.patchValue(course); // Remplir le formulaire avec les données du cours
    } else {
      console.error('Cours non trouvé');
    }
  }

  updateCourse(): void {
    if (this.courseForm.invalid) {
      console.error('Le formulaire est invalide.');
      return;
    }

    const updatedCourse: Course = { id: this.courseId, ...this.courseForm.value };

    this.courseService.updateCourse(this.courseId, updatedCourse).subscribe(
      () => {
        console.log('Cours mis à jour avec succès');
        this.router.navigate(['/main/courses']);
      },
      (error: any) => {
        console.error('Erreur lors de la mise à jour du cours', error);
      }
    );
  }
}