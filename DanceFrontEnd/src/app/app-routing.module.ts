import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DanceCategoryListComponent } from './cruds/DanceCategory/dance-category-list/dance-category-list.component';
import { DanceCategoryAddComponent } from './cruds/DanceCategory/dance-category-add/dance-category-add.component';
import { DanceCategoryUpdateComponent } from './cruds/DanceCategory/dance-category-update/dance-category-update.component';
import { MainComponent } from './cruds/main/main.component';
import { AddschoolComponent } from './cruds/Danceschool/addschool/addschool.component';
import { ListschoolComponent } from './cruds/Danceschool/listschool/listschool.component';
import { UpdateschoolComponent } from './cruds/Danceschool/updateschool/updateschool.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirection vers main par défaut
  {
    path: 'main', component: MainComponent, children: [
      { path: 'categories', component: DanceCategoryListComponent },
      { path: 'categories/add', component: DanceCategoryAddComponent },
      { path: 'categories/update/:id', component: DanceCategoryUpdateComponent },
      // Routes pour les écoles de danse
      { path: 'schools', component: ListschoolComponent },
      { path: 'schools/add', component: AddschoolComponent },
      { path: 'schools/update/:id', component: UpdateschoolComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
