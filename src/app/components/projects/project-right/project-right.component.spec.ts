import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectRightComponent } from './project-right.component';

describe('ProjectRightComponent', () => {
  let component: ProjectRightComponent;
  let fixture: ComponentFixture<ProjectRightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectRightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjectRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
