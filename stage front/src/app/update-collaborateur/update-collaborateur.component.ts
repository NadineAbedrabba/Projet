import { Component, OnInit } from '@angular/core';
import { Collaborateur } from '../model/Collaborateur.model';
import { ActivatedRoute, Router } from '@angular/router';
import { CollaborateurService } from '../collaborateur.service';

@Component({
  selector: 'app-update-collaborateur',
  templateUrl: './update-collaborateur.component.html',
  styleUrls: ['./update-collaborateur.component.css']
})
export class UpdateCollaborateurComponent implements OnInit{

  currentCollaborateur = new Collaborateur();

  constructor(private activatedRoute : ActivatedRoute ,
    private collaborateurService : CollaborateurService ,
    private router : Router) {} ;

  ngOnInit(): void {
    this.collaborateurService.consulterCollaborateur(this.activatedRoute.snapshot.params['id']).
 subscribe( prod =>{ this.currentCollaborateur = prod; } ) ;
  }
  updateCollaborateur() {
    this.collaborateurService.updateProduit(this.currentCollaborateur).subscribe(prod => {
    this.router.navigate(['produits']); }
    );
    }


}
