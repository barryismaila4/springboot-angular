// src/app/cruds/DanceCategory/dance-category-list/dance-category-list.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DanceCategoryService } from '../../../services/dance-category.service';
import { DanceCategory } from 'src/app/models/dance-category';


@Component({
  selector: 'app-dance-category-list',
  templateUrl: './dance-category-list.component.html',
  styleUrls: ['./dance-category-list.component.css']
})
export class DanceCategoryListComponent implements OnInit {
  categories: DanceCategory[] = [];

  constructor(private danceCategoryService: DanceCategoryService, private router: Router) {}

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories(): void {
    this.danceCategoryService.getCategories().subscribe(
      (data) => {
        this.categories = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des catégories', error);
      }
    );
  }

  editCategory(id: number): void {
    this.router.navigate(['/main/categories/update', id]);
  }

  deleteCategory(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette catégorie ?')) {
      this.danceCategoryService.deleteCategory(id).subscribe(
        () => {
          this.loadCategories(); // Recharger les catégories après la suppression
        },
        (error) => {
          console.error('Erreur lors de la suppression de la catégorie', error);
        }
      );
    }
  }
}