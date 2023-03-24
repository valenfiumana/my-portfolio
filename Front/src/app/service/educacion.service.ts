import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {

  expURL = 'http://localhost:8080/educacion/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Educacion[]>{
    return this.httpClient.get<Educacion[]>(this.expURL);
  }

  public getById(id : number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.expURL + id)
  }

  public save(educacion : Educacion): Observable<any>{
    return this.httpClient.post<any>(this.expURL, educacion)
  }

  public update(educacion : Educacion): Observable<any>{
    return this.httpClient.put<any>(this.expURL, educacion)
  }

  public deleteById(id : number): Observable<Educacion>{
    return this.httpClient.delete<Educacion>(this.expURL + id)
  }
}
