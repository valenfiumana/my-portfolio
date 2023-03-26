import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../model/project'

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  pURL = 'https://portfolio-backend-p0je.onrender.com/proyectos/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Project[]>{
    return this.httpClient.get<Project[]>(this.pURL);
  }

  public getById(id : number): Observable<Project>{
    return this.httpClient.get<Project>(this.pURL + id)
  }

  public save(project : Project): Observable<any>{
    return this.httpClient.post<any>(this.pURL, project)
  }

  public update(project : Project): Observable<any>{
    return this.httpClient.put<any>(this.pURL, project)
  }

  public deleteById(id : number): Observable<Project>{
    return this.httpClient.delete<Project>(this.pURL + id)
  }
}
