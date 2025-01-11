import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DanceCategoryListComponent } from './cruds/DanceCategory/dance-category-list/dance-category-list.component';
import { DanceCategoryAddComponent } from './cruds/DanceCategory/dance-category-add/dance-category-add.component';
import { DanceCategoryUpdateComponent } from './cruds/DanceCategory/dance-category-update/dance-category-update.component';
import { MainComponent } from './cruds/main/main.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirection vers main par défaut
  {
    path: 'main', component: MainComponent, children: [
      { path: 'categories', component: DanceCategoryListComponent },
      { path: 'categories/add', component: DanceCategoryAddComponent },
      { path: 'categories/update/:id', component: DanceCategoryUpdateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
