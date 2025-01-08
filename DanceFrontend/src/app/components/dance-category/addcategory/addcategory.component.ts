import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { DanceService } from 'src/app/services/dance.service';
import { Router } from '@angular/router';
import { DanceCategory } from 'src/app/models/dance-category';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {
  categoryForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private danceService: DanceService,
    private router: Router
  ) {
    this.categoryForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.categoryForm.valid) {
      const newCategory: DanceCategory = this.categoryForm.value;
      this.danceService.addDanceCategory(newCategory).subscribe({
        next: (category) => {
          console.log('Category added successfully:', category);
          this.router.navigate(['/categories']); // Redirige vers la liste des catégories après ajout
        },
        error: (err) => {
          console.error('Error adding category:', err);
        }
      });
    }
  }
}