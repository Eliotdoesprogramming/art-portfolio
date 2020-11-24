import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageByIdComponent } from './image-by-id.component';

describe('ImageByIdComponent', () => {
  let component: ImageByIdComponent;
  let fixture: ComponentFixture<ImageByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
