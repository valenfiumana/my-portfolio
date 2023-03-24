import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './components/home/home.component'
import {LoginComponent} from './components/login/login.component'
import {NewExperienceComponent} from 'src/app/components/resume/experience/new-experience.component'
import { EditExperienceComponent } from './components/resume/experience/edit-experience.component';
import { NewEducationComponent } from './components/resume/education/new-education.component';
import { EditEducationComponent } from './components/resume/education/edit-education.component';
import { NewProjectComponent } from './components/projects/new-project.component';
import { EditProjectComponent } from './components/projects/edit-project.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'nuevaexp', component: NewExperienceComponent},
  {path: 'editexp/:id', component: EditExperienceComponent},
  {path: 'neweducation', component: NewEducationComponent},
  {path: 'editeducation/:id', component: EditEducationComponent},
  {path: 'newproject', component: NewProjectComponent},
  {path: 'editproject/:id', component: EditProjectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
