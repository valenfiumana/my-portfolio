import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Skill } from 'src/app/model/skill'
import { SkillService } from 'src/app/service/skill.service'

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent  implements OnInit{
  nombre: string = '';
  porcentaje: number = NaN;

  constructor(private skillService: SkillService, private router: Router){}
  ngOnInit(): void{}

  onCreate(): void {
    const expe = new Skill(this.nombre, this.porcentaje);
    this.skillService.save(expe).subscribe(
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
