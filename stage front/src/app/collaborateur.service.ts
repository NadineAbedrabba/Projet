import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Collaborateur } from './model/Collaborateur.model';
const httpOptions = {headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})
export class CollaborateurService {

  apiURL: string = '/api/collaborateur';

collaborateur! : Collaborateur ; 
collaborateurs! : Collaborateur[] ;
  constructor(private http : HttpClient) {
    }



    consulterCollaborateur(id: number): Observable<Collaborateur> {
      const url = `${this.apiURL}/${id}`;
      return this.http.get<Collaborateur>(url);
      }
      
      

  listeCollaborateurs() :Observable<Collaborateur[]> { 
    return this.http.get<Collaborateur[]>(this.apiURL);

  }


ajouterCollaborateur( collab : Collaborateur) : Observable <Collaborateur>
 {
  return this.http.post<Collaborateur>(this.apiURL, collab, httpOptions);
}

 supprimerCollaborateur(  id : number){

  const url = `${this.apiURL}/${id}`;
  return this.http.delete(url, httpOptions);
  }


  updateProduit(collab :Collaborateur) : Observable<Collaborateur>
  {
  return this.http.put<Collaborateur>(this.apiURL, collab, httpOptions);
  }


trierProduits(){
  this.collaborateurs = this.collaborateurs.sort((n1,n2) => {
  if (n1.idCollaborateur > n2.idCollaborateur) {
  return 1;
  }
  if (n1.idCollaborateur < n2.idCollaborateur) {
  return -1;
  }
  return 0;
  });
  }
  

}
