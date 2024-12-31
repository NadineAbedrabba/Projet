import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CollaborateursComponent } from './collaborateurs/collaborateurs.component';
import { AddcollaborateurComponent } from './addcollaborateur/addcollaborateur.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateCollaborateurComponent } from './update-collaborateur/update-collaborateur.component';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { DomaineComponent } from './domaine/domaine.component';
import { AddDomaineRequestComponent } from './add-domaine-request/add-domaine-request.component';
import { AddDomaineComponent } from './add-domaine/add-domaine.component';
import { CompetenceComponent } from './competence/competence.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { SearchFilterCompetencePipe } from './search-filter-competence.pipe';
import { DomaineUSERComponent } from './domaine-user/domaine-user.component';
import { LoginComponent } from './login/login.component';
import { ProfilcollabComponent } from './profilcollab/profilcollab.component';


@NgModule({
  declarations: [
    AppComponent,
    CollaborateursComponent,
    AddcollaborateurComponent,
    UpdateCollaborateurComponent,
    DomaineComponent,
    AddDomaineRequestComponent,
    AddDomaineComponent,
    CompetenceComponent,
    SearchFilterPipe,
    SearchFilterCompetencePipe,
    DomaineUSERComponent,
    LoginComponent,
    ProfilcollabComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule ,
    
    
   ] ,


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
