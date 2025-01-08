import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcategoryComponent } from './components/dance-category/addcategory/addcategory.component';
import { ListcategoryComponent } from './components/dance-category/listcategory/listcategory.component';

const routes: Routes = [
  { path: 'addcategory', component: AddcategoryComponent },
  { path: 'listcategory', component: ListcategoryComponent },
  { path: '', redirectTo: '/listcategory', pathMatch: 'full' }, // Redirection par défaut
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
