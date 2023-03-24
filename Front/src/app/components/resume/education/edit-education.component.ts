import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion'
import { EducacionService } from 'src/app/service/educacion.service'

@Component({
  selector: 'app-edit-education',
  templateUrl: './edit-education.component.html',
  styleUrls: ['./edit-education.component.css']
})
export class EditEducationComponent implements OnInit{
  educacion: Educacion = null;

  constructor(private educacionService: EducacionService, private activatedRoute: ActivatedRoute, private router: Router){}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.getById(id).subscribe(
      data =>{
        this.educacion = data;
      }, err =>{
        alert("Error al modificar educacion");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.update(this.educacion).subscribe(
      data => {
        alert("Educacion modificada");
        this.router.navigate(['']);
      }, err =>{
          alert("Error al modificar educacion");
          this.router.navigate(['']);
      }
    )
  }

}