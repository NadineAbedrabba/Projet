import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CollaborateursComponent } from './collaborateurs/collaborateurs.component';
import { AddcollaborateurComponent } from './addcollaborateur/addcollaborateur.component';
import { UpdateCollaborateurComponent } from './update-collaborateur/update-collaborateur.component';
import { DomaineComponent } from './domaine/domaine.component';
import { AddDomaineRequestComponent } from './add-domaine-request/add-domaine-request.component';
import { AddDomaineComponent } from './add-domaine/add-domaine.component';
import { CompetenceComponent } from './competence/competence.component';
import { DomaineUSERComponent } from './domaine-user/domaine-user.component';
import { LoginComponent } from './login/login.component';
import { ProfilcollabComponent } from './profilcollab/profilcollab.component';

const routes: Routes = [
  {path : "collaborateurs" , component : CollaborateursComponent} , 
  {path : "addcollaborateur" , component: AddcollaborateurComponent } ,
  { path: "", redirectTo: "login", pathMatch: "full" },
  {path: "updateCollaborateur/:id", component: UpdateCollaborateurComponent},
  {path: "domaine", component: DomaineComponent} ,
  {path: "add-Domaine-Request", component: AddDomaineRequestComponent},
  {path: "add-Domaine", component: AddDomaineComponent },
  {path: "domaine/:id", component: CompetenceComponent },
  {path: "domaineUSER" , component : DomaineUSERComponent},
  {path: 'login', component: LoginComponent},
  {path: "profilcollab/:id", component:  ProfilcollabComponent },






  

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
