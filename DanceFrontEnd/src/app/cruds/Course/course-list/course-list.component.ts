// src/app/cruds/Course/course-list/course-list.component.ts
import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../../services/course.service';
import { Course } from 'src/app/models/course';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];

  constructor(private courseService: CourseService, private router: Router) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.courseService.getCourses().subscribe(
      (data) => {
        this.courses = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des cours', error);
      }
    );
  }

  editCourse(id: number): void {
    this.router.navigate(['/main/courses/update', id]); // Redirige vers le composant de mise à jour
  }

  deleteCourse(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce cours ?')) {
      this.courseService.deleteCourse(id).subscribe(
        () => {
          this.loadCourses(); // Recharger la liste après la suppression
          console.log('Cours supprimé avec succès');
        },
        (error) => {
          console.error('Erreur lors de la suppression du cours', error);
        }
      );
    }
  }
}