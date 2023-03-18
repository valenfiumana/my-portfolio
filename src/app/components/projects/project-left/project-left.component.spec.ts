import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectLeftComponent } from './project-left.component';

describe('ProjectLeftComponent', () => {
  let component: ProjectLeftComponent;
  let fixture: ComponentFixture<ProjectLeftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectLeftComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjectLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
