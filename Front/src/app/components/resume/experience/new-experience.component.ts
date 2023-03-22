import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Experiencia } from 'src/app/model/experiencia'
import { ExperienciaService } from 'src/app/service/experiencia.service'

@Component({
  selector: 'app-new-experience',
  templateUrl: './new-experience.component.html',
  styleUrls: ['./new-experience.component.css']
})

export class NewExperienceComponent implements OnInit{
  puesto: string = '';
  descripcion: string = '';
  img_institucion : string = '';
  anioInicio: number = NaN;
  anioFin: number = NaN;

  constructor(private experienciaService: ExperienciaService, private router: Router){}
  ngOnInit(): void{}

  onCreate(): void {
    const expe = new Experiencia(this.puesto, this.descripcion, this.img_institucion, this.anioInicio, this.anioFin);
    this.experienciaService.save(expe).subscribe(
      data => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
}
