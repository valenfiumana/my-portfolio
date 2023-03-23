import { Component, OnInit } from '@angular/core';
import { ExperienciaService } from 'src/app/service/experiencia.service';
import {Experiencia} from 'src/app/model/experiencia';
import {TokenService} from 'src/app/service/token.service'
@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit{
  expe: Experiencia[] = [];

  constructor(private experienciaService: ExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.experienciaService.lista().subscribe(data => { this.expe = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.experienciaService.deleteById(id).subscribe(
        data => {
          this.cargarExperiencia();
          location.reload();
        }, err => {
          this.cargarExperiencia();
        }
      )
    }
  }
}
