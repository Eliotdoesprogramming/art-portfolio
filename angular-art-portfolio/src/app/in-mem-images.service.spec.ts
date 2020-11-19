import { TestBed } from '@angular/core/testing';

import { InMemImagesService } from './in-mem-images.service';

describe('InMemImagesService', () => {
  let service: InMemImagesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InMemImagesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
