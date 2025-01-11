// src/app/cruds/DanceCategory/dance-category-add/dance-category-add.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DanceCategoryService } from '../../../services/dance-category.service';
import { DanceCategory } from 'src/app/models/dance-category';

@Component({
  selector: 'app-dance-category-add',
  templateUrl: './dance-category-add.component.html',
  styleUrls: ['./dance-category-add.component.css']
})
export class DanceCategoryAddComponent implements OnInit {
  categoryForm!: FormGroup;

  constructor(
    private danceCategoryService: DanceCategoryService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.createForm();
  }

  createForm(): void {
    this.categoryForm = this.fb.group({
      name: ['', [Validators.required]],
      danceSchools: [[]],
      courses: [[]]
    });
  }

  addCategory(): void {
    if (this.categoryForm.invalid) {
      console.error('Le formulaire est invalide.');
      return;
    }

    const category: DanceCategory = this.categoryForm.value;

    this.danceCategoryService.addCategory(category).subscribe(
      (response) => {
        console.log('Catégorie ajoutée avec succès', response);
        this.router.navigate(['/main/categories']);
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de la catégorie', error);
        alert('Une erreur est survenue lors de l\'ajout de la catégorie.');
      }
    );
  }

  // Ajoutez cette méthode pour gérer l'annulation
  cancel(): void {
    this.categoryForm.reset(); // Réinitialise le formulaire
    this.router.navigate(['/main/categories']); // Redirige vers la liste des catégories
  }
}