import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {NuevoUsuario} from 'src/app/model/nuevo-usuario'
import {LoginUsuario} from 'src/app/model/login-usuario'
import {JwtDto} from 'src/app/model/jwt-dto'


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  URL = 'http://localhost:8080/auth/'
  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario: NuevoUsuario): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'nuevo', nuevoUsuario);
  }

  public login(loginUsuario: LoginUsuario): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.URL + 'login', loginUsuario)
  }
}
