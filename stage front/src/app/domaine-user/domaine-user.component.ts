import { Component, OnInit } from '@angular/core';
import { Domaine } from '../model/Domaine.model';
import { DomaineService } from '../domaine.service';

@Component({
  selector: 'app-domaine-user',
  templateUrl: './domaine-user.component.html',
  styleUrls: ['./domaine-user.component.css']
})
export class DomaineUSERComponent implements OnInit {

  domaines! : Domaine[] ; 
  alldomaines! : Domaine[]  ;
  
  constructor( private domaineService : DomaineService){}

 
    chargerDomaines(){
      this.domaineService.listeDomaine().subscribe(d => {
      console.log(d);
      this.domaines = d;
      }); 
      }
      supprimerDomaine(d: Domaine)
      {
      let conf = confirm("Etes-vous sûr ?");
      if (conf)
      this.domaineService.supprimerDomaine(d.nomDomaine).subscribe(() => {
      console.log("produit supprimé");
      this.chargerDomaines();
      });
      } 

searchTerm!: string;

ngOnInit(): void {
  
  this.domaineService.listeDomaine().subscribe(prods => {
    console.log(prods);
    this.alldomaines = prods;
    this.domaines = this.alldomaines; // Initialise le tableau des domaines à l'affichage initial
  });
}
onKeyUp(filterText: string) {
  const lowercaseFilterText = filterText.toLowerCase(); // Convert the filter text to lowercase
  
  this.domaines = this.alldomaines.filter(item =>
    item.nomDomaine.toLowerCase().includes(lowercaseFilterText) // Convert the domain name to lowercase for comparison
  );
}


      

}


