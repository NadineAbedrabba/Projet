import { CollaborateurService } from '../collaborateur.service';
import { Collaborateur } from './../model/Collaborateur.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-collaborateurs',
  templateUrl: './collaborateurs.component.html',
  styleUrls: ['./collaborateurs.component.css']
})
export class  CollaborateursComponent implements OnInit {
  selected: Boolean=true ; 


  page : number =1 ;
  count : number =0 ;
  tableSize : number =9 ;
  tableSizes : any =[5 ,10 ,15 ,20] ;

  collaborateurs! : Collaborateur[] ;
  constructor( private collaborateurService :CollaborateurService) {
  } ; 



  checkedCollaborateurs: Set<number> = new Set();

  toggleCheckbox(index: number) {
    if (this.checkedCollaborateurs.has(index)) {
      this.checkedCollaborateurs.delete(index);
    } else {
      this.checkedCollaborateurs.add(index);
    }
  }

  chargerCollaborateurs() : void{
    this.collaborateurService.listeCollaborateurs().subscribe(collabs => {
    console.log(collabs);
    this.collaborateurs = collabs;
    }); 
    }
    supprimerCollaborateur(collab: Collaborateur , index :number) {
      let conf = confirm("Etes-vous sûr ?");
      if (conf) {
        this.collaborateurService.supprimerCollaborateur(collab.idCollaborateur).subscribe(() => {
          console.log("collaborateur supprimé");
          
          // Mettre à jour l'ensemble des cases cochées après la suppression
          this.checkedCollaborateurs.delete(index); // Assurez-vous que collab.index correspond à l'index de l'élément à supprimer
          
          this.chargerCollaborateurs(); // Mettre à jour la liste des collaborateurs
        });
      }
    }
    
    
  onTableDataChange(event : any) {
    this.page = event ;
    this.chargerCollaborateurs() ;
  }

    onTableSizeCHange(event : any):void {
      this.tableSize = event.target.value ;
      this.page =1 ;
      this.chargerCollaborateurs();
    }


    searchTerm!: string;
    allcollaborateurs! : Collaborateur[]  ;
    
    ngOnInit(): void {
      this.collaborateurService.listeCollaborateurs().subscribe(prods => {
        console.log(prods);
        this.allcollaborateurs = prods;
        this.collaborateurs = this.allcollaborateurs; // Initialise le tableau des domaines à l'affichage initial
      });
    }

    
    onKeyUp(filterText : string){
    this.collaborateurs = this.allcollaborateurs.filter(item =>
    item.nomCollaborateur.toLowerCase().includes(filterText));
    }
    

isLastPage(): boolean {
  const totalPages = Math.ceil(this.collaborateurs.length / this.tableSize);
  return this.page === totalPages;
}

nombreItems(): number {
  if (this.isLastPage()) {
    // Si c'est la dernière page, renvoie simplement le nombre d'éléments restants
    return this.collaborateurs.length - (this.page - 1) * this.tableSize;
  } else {
    // Calcul du nombre d'éléments sur les pages non dernières
    return this.tableSize;
  }
}


}






