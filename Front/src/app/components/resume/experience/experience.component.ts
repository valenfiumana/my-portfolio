import { Component, OnInit } from '@angular/core';
import {ExperienciaService} from 'src/app/service/experiencia.service'
import {Experiencia} from 'src/app/model/experiencia'

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent {
  experiencia : Experiencia[] = []

  constructor(private experienciaService: ExperienciaService){

  }

  ngOnInit(): void{

  }

  cargarExperiencia():void{
    this.experienciaService.lista().subscribe(data => {this.experiencia = data})
  }
}
