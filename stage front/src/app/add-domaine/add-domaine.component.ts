import { Component, OnInit } from '@angular/core';
import { DomaineService } from '../domaine.service';
import { Domaine } from '../model/Domaine.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-domaine',
  templateUrl: './add-domaine.component.html',
  styleUrls: ['./add-domaine.component.css']
})
export class AddDomaineComponent implements OnInit{



  constructor(private domaineService : DomaineService ,
              private router : Router ) {}
 newDomaine!:Domaine ; 
  addDomaine(){
    this.domaineService.ajouterDomaine(this.newDomaine)
    .subscribe(d => {
    console.log(d);
    this.router.navigate(['domaine']);
    });
    }

    ngOnInit(): void {
        
    }
    

}
