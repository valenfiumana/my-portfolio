import { Component, OnInit } from '@angular/core';
import {TokenService} from 'src/app/service/token.service'
import { SkillService } from 'src/app/service/skill.service';
import { Skill } from 'src/app/model/skill';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit{
  skills: Skill[] = [];

  constructor(private skillService: SkillService, private tokenService: TokenService) { }

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
    this.skillService.lista().subscribe(data => { this.skills = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.skillService.deleteById(id).subscribe(
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
