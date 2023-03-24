import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../model/project'

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  expURL = 'http://localhost:8080/proyectos/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Project[]>{
    return this.httpClient.get<Project[]>(this.expURL);
  }

  public getById(id : number): Observable<Project>{
    return this.httpClient.get<Project>(this.expURL + id)
  }

  public save(project : Project): Observable<any>{
    return this.httpClient.post<any>(this.expURL, project)
  }

  public update(project : Project): Observable<any>{
    return this.httpClient.put<any>(this.expURL, project)
  }

  public deleteById(id : number): Observable<Project>{
    return this.httpClient.delete<Project>(this.expURL + id)
  }
}
