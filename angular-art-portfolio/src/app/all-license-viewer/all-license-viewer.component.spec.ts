import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllLicenseViewerComponent } from './all-license-viewer.component';

describe('AllLicenseViewerComponent', () => {
  let component: AllLicenseViewerComponent;
  let fixture: ComponentFixture<AllLicenseViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllLicenseViewerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllLicenseViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
