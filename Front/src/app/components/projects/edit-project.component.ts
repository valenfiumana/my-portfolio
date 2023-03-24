import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/model/project'
import { ProjectService } from 'src/app/service/project.service'


@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit{
  project: Project = null;

  constructor(private projectService: ProjectService, private activatedRoute: ActivatedRoute, private router: Router){}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.projectService.getById(id).subscribe(
      data =>{
        this.project = data;
      }, err =>{
        alert("Error al modificar proyecto");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.projectService.update(this.project).subscribe(
      data => {
        alert("Proyecto modificado");
        this.router.navigate(['']);
      }, err =>{
          alert("Error al modificar proyecto");
          this.router.navigate(['']);
      }
    )
  }

}