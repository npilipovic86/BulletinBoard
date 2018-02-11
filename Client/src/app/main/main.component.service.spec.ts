import { TestBed, inject } from '@angular/core/testing';

import { MainComponentService } from './main.component.service';

describe('Main.ComponentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MainComponentService]
    });
  });

  it('should be created', inject([MainComponentService], (service: MainComponentService) => {
    expect(service).toBeTruthy();
  }));
});
