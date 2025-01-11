import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DanceCategoryListComponent } from './dance-category-list.component';

describe('DanceCategoryListComponent', () => {
  let component: DanceCategoryListComponent;
  let fixture: ComponentFixture<DanceCategoryListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DanceCategoryListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DanceCategoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
