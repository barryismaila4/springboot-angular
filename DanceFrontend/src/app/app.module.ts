import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'; // Assurez-vous que ce module est importé
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddcategoryComponent } from './components/dance-category/addcategory/addcategory.component';
import { ListcategoryComponent } from './components/dance-category/listcategory/listcategory.component';

@NgModule({
  declarations: [
    AppComponent,
    AddcategoryComponent,
    ListcategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule, // Assurez-vous que ce module est importé
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }