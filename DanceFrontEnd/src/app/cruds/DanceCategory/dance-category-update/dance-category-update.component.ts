// src/app/cruds/DanceCategory/dance-category-update/dance-category-update.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DanceCategoryService } from '../../../services/dance-category.service';
import { DanceCategory } from 'src/app/models/dance-category';


@Component({
  selector: 'app-dance-category-update',
  templateUrl: './dance-category-update.component.html',
  styleUrls: ['./dance-category-update.component.css']
})
export class DanceCategoryUpdateComponent implements OnInit {
  category: DanceCategory = { id: 0, name: '' };

  constructor(
    private danceCategoryService: DanceCategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.loadCategory(id);
  }

  loadCategory(id: number): void {
    this.danceCategoryService.getCategories().subscribe(
      (data) => {
        this.category = data.find(cat => cat.id === id)!;
      },
      (error) => {
        console.error('Erreur lors du chargement de la catégorie', error);
      }
    );
  }

  updateCategory(): void {
    this.danceCategoryService.updateCategory(this.category.id, this.category).subscribe(
      () => {
        this.router.navigate(['/main/categories']); // Rediriger vers la liste après la mise à jour
      },
      (error) => {
        console.error('Erreur lors de la mise à jour de la catégorie', error);
      }
    );
  }
}