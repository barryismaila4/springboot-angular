import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DanceCategoryUpdateComponent } from './dance-category-update.component';

describe('DanceCategoryUpdateComponent', () => {
  let component: DanceCategoryUpdateComponent;
  let fixture: ComponentFixture<DanceCategoryUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DanceCategoryUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DanceCategoryUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
