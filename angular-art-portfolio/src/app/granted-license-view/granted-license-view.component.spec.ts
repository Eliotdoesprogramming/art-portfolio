import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GrantedLicenseViewComponent } from './granted-license-view.component';

describe('GrantedLicenseViewComponent', () => {
  let component: GrantedLicenseViewComponent;
  let fixture: ComponentFixture<GrantedLicenseViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GrantedLicenseViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GrantedLicenseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
