import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

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
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { InterceptorProvider } from 'src/app/service/interceptor.service';
import { NewExperienceComponent } from './components/resume/experience/new-experience.component';
import { EditExperienceComponent } from './components/resume/experience/edit-experience.component';
import { EducationComponent } from './components/resume/education/education.component';
import { NewEducationComponent } from './components/resume/education/new-education.component';
import { EditEducationComponent } from './components/resume/education/edit-education.component';
import { EditProjectComponent } from './components/projects/edit-project.component';
import { NewProjectComponent } from './components/projects/new-project.component';

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
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NewExperienceComponent,
    EditExperienceComponent,
    EducationComponent,
    NewEducationComponent,
    EditEducationComponent,
    EditProjectComponent,
    NewProjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
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
  providers: [
    InterceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
