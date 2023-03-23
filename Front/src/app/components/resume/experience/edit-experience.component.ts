import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-edit-experience',
  templateUrl: './edit-experience.component.html',
  styleUrls: ['./edit-experience.component.css']
})
export class EditExperienceComponent implements OnInit{
  experiencia: Experiencia = null;

  constructor(private experienciaService: ExperienciaService, private activatedRoute: ActivatedRoute, private router: Router){}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.experienciaService.getById(id).subscribe(
      data =>{
        this.experiencia = data;
      }, err =>{
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.experienciaService.update(this.experiencia).subscribe(
      data => {
        this.router.navigate(['']);
      }, err =>{
          alert("Error al modificar experiencia");
          this.router.navigate(['']);
      }
    )
  }

}
