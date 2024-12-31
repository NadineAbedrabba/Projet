import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilcollabComponent } from './profilcollab.component';

describe('ProfilcollabComponent', () => {
  let component: ProfilcollabComponent;
  let fixture: ComponentFixture<ProfilcollabComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfilcollabComponent]
    });
    fixture = TestBed.createComponent(ProfilcollabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
