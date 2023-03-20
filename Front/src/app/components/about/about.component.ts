import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.module';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  persona: persona = new persona("", "", "", "", "", "", "", "");
  constructor (public PersonaService: PersonaService){}
  ngOnInit(): void {
    this.PersonaService.getPersona().subscribe(data => {this.persona = data})
  }
}
