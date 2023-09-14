import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraderFormComponent } from './trader-form.component';

describe('TraderFormComponent', () => {
  let component: TraderFormComponent;
  let fixture: ComponentFixture<TraderFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TraderFormComponent]
    });
    fixture = TestBed.createComponent(TraderFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
