import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Skill } from '../model/skill'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  skillURL = 'http://localhost:8080/skills/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.skillURL);
  }

  public getById(id : number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.skillURL + id)
  }

  public save(skill : Skill): Observable<any>{
    return this.httpClient.post<any>(this.skillURL, skill)
  }

  public update(skill : Skill): Observable<any>{
    return this.httpClient.put<any>(this.skillURL, skill)
  }

  public deleteById(id : number): Observable<Skill>{
    return this.httpClient.delete<Skill>(this.skillURL + id)
  }
}
