import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Domaine } from './model/Domaine.model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class DomaineService {
  apiURL: string = '/stage/api/domaine';

  constructor(private http: HttpClient) { }
  listeDomaine(): Observable<Domaine[]> {
    return this.http.get<Domaine[]>(this.apiURL);
  }

  ajouterDomaine(d: Domaine): Observable<Domaine> {
    return this.http.post<Domaine>(this.apiURL, d, httpOptions);
  }


  supprimerDomaine(id: string) {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }


  



}
