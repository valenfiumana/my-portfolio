import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NavComponent } from './components/header/nav/nav.component';
import { BannerComponent } from './components/header/banner/banner.component';
import { AboutComponent } from './components/about/about.component';
import { ResumeComponent } from './components/resume/resume.component';
import { ExperienceComponent } from './components/resume/experience/experience.component';
// Import ng-circle-progress
import { NgCircleProgressModule } from 'ng-circle-progress';
import { SkillsComponent } from './components/skills/skills.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { ProjectLeftComponent } from './components/projects/project-left/project-left.component';
import { ProjectRightComponent } from './components/projects/project-right/project-right.component';
import { FooterComponent } from './components/footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavComponent,
    BannerComponent,
    AboutComponent,
    ResumeComponent,
    ExperienceComponent,
    SkillsComponent,
    ProjectsComponent,
    ProjectLeftComponent,
    ProjectRightComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgCircleProgressModule.forRoot({
      "radius": 70,
      "maxPercent": 100,
      "showSubtitle": false,
      "showUnits": false,
      "outerStrokeColor": "#ffc107",
      "innerStrokeColor": "#ffe7a3",
      "innerStrokeWidth": 3,
      "titleColor": "#8f8f8f",
      "subtitleColor": "#9c9c9c"
    })],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
