import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Competence } from './model/Competence.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const httpOptions = {headers: new HttpHeaders( {'Content-Type': 'application/json'} )}

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {
  apiURL: string = '/api/competence';

  competence! : Competence ; 
  competences! : Competence[] ;
    constructor(private http : HttpClient) {
      }
  
  
  
      consulterCompetence(id: number): Observable<Competence> {
        const url = `${this.apiURL}/${id}`;
        return this.http.get<Competence>(url);
        }
        
        
  
    listeCompetences() :Observable<Competence[]> { 
      return this.http.get<Competence[]>(this.apiURL);
  
    }
  
  
  ajouterCollaborateur( collab : Competence) : Observable <Competence>
   {
    return this.http.post<Competence>(this.apiURL, collab, httpOptions);
  }
  
   supprimerCompetence(  id : string){
  
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
    }
  
  
    updateCompetence(collab :Competence) : Observable<Competence>
    {
    return this.http.put<Competence>(this.apiURL, collab, httpOptions);
    }
  
  
  trierCompetence(){
    this.competences = this.competences.sort((n1,n2) => {
    if (n1.nomCompetence > n2.nomCompetence) {
    return 1;
    }
    if (n1.nomCompetence < n2.nomCompetence) {
    return -1;
    }
    return 0;
    });
    }
    checkCompetenceExists(nom: string): Observable<boolean> {
      return new Observable<boolean>(subscriber => {
        this.listeCompetences().subscribe(competences => {
          const exists = competences.every(item => item.nomCompetence !== nom);
          subscriber.next(exists);
          subscriber.complete();
        });
      });
    }
   
  
    
  
  }
