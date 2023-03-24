import { Component, OnInit } from '@angular/core';
import {TokenService} from 'src/app/service/token.service'
import { ProjectService } from 'src/app/service/project.service';
import { Project } from 'src/app/model/project';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit{
  projects: Project[] = [];

  constructor(private projectService: ProjectService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyectos();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProyectos(): void {
    this.projectService.lista().subscribe(data => { this.projects = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.projectService.deleteById(id).subscribe(
        data => {
          this.cargarProyectos();
          location.reload();
        }, err => {
          this.cargarProyectos();
        }
      )
    }
  }
}