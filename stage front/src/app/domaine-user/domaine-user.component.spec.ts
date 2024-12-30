import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DomaineUSERComponent } from './domaine-user.component';

describe('DomaineUSERComponent', () => {
  let component: DomaineUSERComponent;
  let fixture: ComponentFixture<DomaineUSERComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DomaineUSERComponent]
    });
    fixture = TestBed.createComponent(DomaineUSERComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
