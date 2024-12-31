import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDomaineRequestComponent } from './add-domaine-request.component';

describe('AddDomaineRequestComponent', () => {
  let component: AddDomaineRequestComponent;
  let fixture: ComponentFixture<AddDomaineRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddDomaineRequestComponent]
    });
    fixture = TestBed.createComponent(AddDomaineRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
