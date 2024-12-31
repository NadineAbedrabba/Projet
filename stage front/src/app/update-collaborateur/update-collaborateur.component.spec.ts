import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCollaborateurComponent } from './update-collaborateur.component';

describe('UpdateCollaborateurComponent', () => {
  let component: UpdateCollaborateurComponent;
  let fixture: ComponentFixture<UpdateCollaborateurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateCollaborateurComponent]
    });
    fixture = TestBed.createComponent(UpdateCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
