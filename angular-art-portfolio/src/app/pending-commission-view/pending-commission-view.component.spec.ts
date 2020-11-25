import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingCommissionViewComponent } from './pending-commission-view.component';

describe('PendingCommissionViewComponent', () => {
  let component: PendingCommissionViewComponent;
  let fixture: ComponentFixture<PendingCommissionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingCommissionViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingCommissionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
