import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllGrantedComponent } from './view-all-granted.component';

describe('ViewAllGrantedComponent', () => {
  let component: ViewAllGrantedComponent;
  let fixture: ComponentFixture<ViewAllGrantedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAllGrantedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllGrantedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
