import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DanceCategoryListComponent } from './cruds/DanceCategory/dance-category-list/dance-category-list.component';
import { DanceCategoryAddComponent } from './cruds/DanceCategory/dance-category-add/dance-category-add.component';
import { DanceCategoryUpdateComponent } from './cruds/DanceCategory/dance-category-update/dance-category-update.component';
import { MainComponent } from './cruds/main/main.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms'; // Import de FormsModule

@NgModule({
  declarations: [
    AppComponent,
    DanceCategoryListComponent,
    DanceCategoryAddComponent,
    DanceCategoryUpdateComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // Pour les appels HTTP
    ReactiveFormsModule, // Pour les formulaires réactifs
    FormsModule // Ajouter FormsModule pour les formulaires basés sur les modèles
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
