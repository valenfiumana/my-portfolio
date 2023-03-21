import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Experiencia } from '../model/experiencia'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  expURL = 'http://localhost:8080/experiencia/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Experiencia[]>{
    return this.httpClient.get<Experiencia[]>(this.expURL);
  }

  public getById(id : number): Observable<Experiencia>{
    return this.httpClient.get<Experiencia>(this.expURL + id)
  }

  public save(experiencia : Experiencia): Observable<any>{
    return this.httpClient.post<any>(this.expURL, experiencia)
  }

  public update(experiencia : Experiencia): Observable<any>{
    return this.httpClient.put<any>(this.expURL, experiencia)
  }

  public deleteById(id : number): Observable<Experiencia>{
    return this.httpClient.delete<Experiencia>(this.expURL + id)
  }
}
