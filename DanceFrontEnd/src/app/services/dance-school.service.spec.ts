import { TestBed } from '@angular/core/testing';

import { DanceSchoolService } from './dance-school.service';

describe('DanceSchoolService', () => {
  let service: DanceSchoolService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DanceSchoolService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
