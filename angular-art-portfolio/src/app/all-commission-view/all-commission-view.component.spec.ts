import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCommissionViewComponent } from './all-commission-view.component';

describe('AllCommissionViewComponent', () => {
  let component: AllCommissionViewComponent;
  let fixture: ComponentFixture<AllCommissionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllCommissionViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllCommissionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
