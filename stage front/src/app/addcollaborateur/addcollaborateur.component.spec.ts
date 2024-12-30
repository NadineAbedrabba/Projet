import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcollaborateurComponent } from './addcollaborateur.component';

describe('AddcollaborateurComponent', () => {
  let component: AddcollaborateurComponent;
  let fixture: ComponentFixture<AddcollaborateurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddcollaborateurComponent]
    });
    fixture = TestBed.createComponent(AddcollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
