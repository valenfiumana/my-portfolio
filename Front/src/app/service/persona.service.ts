import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { persona } from '../model/persona.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL + '1')
  }
}
