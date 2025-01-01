import { Component, OnInit } from '@angular/core';
import { Collaborateur } from '../model/Collaborateur.model';
import { CollaborateurService } from '../collaborateur.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcollaborateur',
  templateUrl: './addcollaborateur.component.html',
  styleUrls: ['./addcollaborateur.component.css']
})
export class AddcollaborateurComponent implements OnInit{

  newCollaborateur = new Collaborateur() ; 

  addCollaborateur(){
    this.collaborateurService.ajouterCollaborateur(this.newCollaborateur)
.subscribe(prod => {
console.log(prod);
this.router.navigate(['collaborateurs']);
});
    }
  constructor(private collaborateurService : CollaborateurService
    , private router : Router) {

  } 
  ngOnInit(): void {
      
  }

}
