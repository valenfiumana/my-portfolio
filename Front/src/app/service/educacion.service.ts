import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {

  edURL = 'https://portfolio-backend-p0je.onrender.com/educacion/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Educacion[]>{
    return this.httpClient.get<Educacion[]>(this.edURL);
  }

  public getById(id : number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.edURL + id)
  }

  public save(educacion : Educacion): Observable<any>{
    return this.httpClient.post<any>(this.edURL, educacion)
  }

  public update(educacion : Educacion): Observable<any>{
    return this.httpClient.put<any>(this.edURL, educacion)
  }

  public deleteById(id : number): Observable<Educacion>{
    return this.httpClient.delete<Educacion>(this.edURL + id)
  }
}
