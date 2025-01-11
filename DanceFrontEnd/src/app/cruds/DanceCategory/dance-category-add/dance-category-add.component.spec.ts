import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DanceCategoryAddComponent } from './dance-category-add.component';

describe('DanceCategoryAddComponent', () => {
  let component: DanceCategoryAddComponent;
  let fixture: ComponentFixture<DanceCategoryAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DanceCategoryAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DanceCategoryAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
