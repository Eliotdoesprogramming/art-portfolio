import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendinglrqViewerComponent } from './pendinglrq-viewer.component';

describe('PendinglrqViewerComponent', () => {
  let component: PendinglrqViewerComponent;
  let fixture: ComponentFixture<PendinglrqViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendinglrqViewerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendinglrqViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
