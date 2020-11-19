import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllImagesComponent } from './display-all-images.component';

describe('DisplayAllImagesComponent', () => {
  let component: DisplayAllImagesComponent;
  let fixture: ComponentFixture<DisplayAllImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllImagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayAllImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
