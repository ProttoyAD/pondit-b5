import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertCodeModalComponent } from './insert-code-modal.component';

describe('InsertCodeModalComponent', () => {
  let component: InsertCodeModalComponent;
  let fixture: ComponentFixture<InsertCodeModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertCodeModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertCodeModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
