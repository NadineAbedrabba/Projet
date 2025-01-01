import { CompetenceService } from './../competence.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Competence } from '../model/Competence.model';
import { Domaine } from '../model/Domaine.model';

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit{

  selected: Boolean=true ; 


  page : number =1 ;
  count : number =0 ;
  tableSize : number =9 ;
  tableSizes : any =[5 ,10 ,15 ,20] ;

  competences! : Competence[] ;
  constructor( private competenceService :CompetenceService , private route: ActivatedRoute , private router : Router) {
  } ; 

 

  checkedCollaborateurs: Set<number> = new Set();

  toggleCheckbox(index: number) {
    if (this.checkedCollaborateurs.has(index)) {
      this.checkedCollaborateurs.delete(index);
    } else {
      this.checkedCollaborateurs.add(index);
    }
  }
  updateScore(comp: any, value: number) {
   comp.niveauCompetence=this.getNiveauText(value) ;
    comp.scoreCompetence = value;
    this.competenceService.updateCompetence(comp).subscribe(prod => {}
      );

  }
  chargerCompetences() : void{
    this.route.params.subscribe(params => {
      this.domaineId = params['id'];
      this.competenceService.listeCompetences().subscribe(prods => {
        this.allcompetences = prods.filter(comp => comp.domaine.nomDomaine == this.domaineId);
        this.competences = this.allcompetences; // Initialise le tableau des domaines à l'affichage initial
      })})}


    supprimerCollaborateur(collab: Competence , index :number) {
      let conf = confirm("Etes-vous sûr ?");
      if (conf) {
        this.competenceService.supprimerCompetence(collab.nomCompetence).subscribe(() => {
          console.log("collaborateur supprimé");
          
          // Mettre à jour l'ensemble des cases cochées après la suppression
          this.checkedCollaborateurs.delete(index); // Assurez-vous que collab.index correspond à l'index de l'élément à supprimer
          
          this.chargerCompetences(); // Mettre à jour la liste des collaborateurs
        });
      }
    }
    
    
  onTableDataChange(event : any) {
    this.page = event ;
    this.chargerCompetences() ;
  }

    onTableSizeCHange(event : any):void {
      this.tableSize = event.target.value ;
      this.page =1 ;
      this.chargerCompetences();
    }

    domaineId: string="";
    searchTerm!: string;
    allcompetences! : Competence[]  ;
    
    ngOnInit(): void {
      
        this.chargerCompetences() ; 
            this.initialiser();

         
      
      
        }
      

      initialiser() {
        for (let comp of this.competences) {
          if (comp.scoreCompetence === null) {
            comp.scoreCompetence = 0;
          }
          if (comp.niveauCompetence === null) {
            comp.niveauCompetence = 'non évalué';
          }
        }
      }
      getNiveauText(score: number): string {
        if (score === 0) {
          return "Pas de compétence";
        } else if (score === 1) {
          return "Débutant(e)";
        } else if (score >= 2 && score <= 3) {
          return "Intermédiaire";
        } else if (score >= 4 && score <= 5) {
          return "Avancé(e)";
        } else {
          return "Niveau non évalué";
        }
      }
      
    
      
    

    
    onKeyUp(filterText : string){
    this.competences = this.allcompetences.filter(item =>
    item.nomCompetence.toLowerCase().includes(filterText));
    }
    

isLastPage(): boolean {
  const totalPages = Math.ceil(this.allcompetences.length / this.tableSize);
  return this.page === totalPages;
}

nombreItems(): number {
  if (this.isLastPage()) {
    // Si c'est la dernière page, renvoie simplement le nombre d'éléments restants
    return this.competences.length - (this.page - 1) * this.tableSize;
  } else {
    // Calcul du nombre d'éléments sur les pages non dernières
    return this.tableSize;
  }
}


newCompetence: Competence = new Competence();
  addCompetence(): void{
    this.competenceService.checkCompetenceExists(this.newCompetence.nomCompetence)
    .subscribe(exists => {
      if (!exists) {
        alert('This competence already exists in the database.');
      } else {
        if (!this.newCompetence.domaine) {
          // Si ce n'est pas le cas, initialisez-le avec un nouvel objet Domaine
          this.newCompetence.domaine = new Domaine();
        }
        
        // Affectez ensuite le nomDomaine au nouvel objet de compétence
        this.newCompetence.domaine.nomDomaine = this.domaineId;
        
        if(this.competenceService.checkCompetenceExists(this.newCompetence.nomCompetence)) {
            this.competenceService.ajouterCollaborateur(this.newCompetence)
        .subscribe(prod => {
        console.log(prod);
        this.navigateToLastPage();
        });
        }
      }
    });
}

















navigateToLastPage() {
  // Vous devrez adapter cette fonction en fonction de la logique de votre pagination et de votre service de compétence
    const lastPage = Math.ceil(this.allcompetences.length / this.tableSize);
    this.page = lastPage;
    this.chargerCompetences();
  
}
  
}
