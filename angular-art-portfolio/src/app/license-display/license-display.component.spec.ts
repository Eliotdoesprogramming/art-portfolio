import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LicenseDisplayComponent } from './license-display.component';

describe('LicenseDisplayComponent', () => {
  let component: LicenseDisplayComponent;
  let fixture: ComponentFixture<LicenseDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LicenseDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LicenseDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
