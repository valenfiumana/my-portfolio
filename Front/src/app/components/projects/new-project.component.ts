import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Project } from 'src/app/model/project'
import { ProjectService } from 'src/app/service/project.service'


@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit{
  titulo: string = '';
  descripcion: string = '';
  img_institucion : string = '';
  url_imagen : string;
  url_proyecto : string;

  constructor(private projectService: ProjectService, private router: Router){}
  ngOnInit(): void{}

  onCreate(): void {
    const expe = new Project(this.titulo, this.url_imagen, this.url_proyecto, this.descripcion);
    this.projectService.save(expe).subscribe(
      data => {
        alert("Proyecto añadido");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
}
