import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Educacion } from 'src/app/model/educacion'
import { EducacionService } from 'src/app/service/educacion.service'

@Component({
  selector: 'app-new-education',
  templateUrl: './new-education.component.html',
  styleUrls: ['./new-education.component.css']
})
export class NewEducationComponent implements OnInit{
  titulo: string = '';
  descripcion: string = '';
  img_institucion : string = '';
  anioInicio: number = NaN;
  anioFin: number = NaN;

  constructor(private educacionService: EducacionService, private router: Router){}
  ngOnInit(): void{}

  onCreate(): void {
    const expe = new Educacion(this.titulo, this.descripcion, this.img_institucion, this.anioInicio, this.anioFin);
    this.educacionService.save(expe).subscribe(
      data => {
        alert("Educacion añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
}
