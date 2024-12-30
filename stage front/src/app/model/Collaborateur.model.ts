import { Domaine } from "./Domaine.model";

export class Collaborateur {
   idCollaborateur! : number ;
	 nomCollaborateur! :string; 
	 prenomCollaborateur! :string ; 
 dateDeNaissance! : Date; 
 emailCollaborateur! : string; 
	 telCollaborateur! :number; 
     positionCollaborateur!: string ;
	 domaines : Domaine[] = []


}