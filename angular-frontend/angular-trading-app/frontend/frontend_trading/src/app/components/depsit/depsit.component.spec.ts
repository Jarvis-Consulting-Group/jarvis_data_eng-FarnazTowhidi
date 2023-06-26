import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepsitComponent } from './depsit.component';

describe('DepsitComponent', () => {
  let component: DepsitComponent;
  let fixture: ComponentFixture<DepsitComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DepsitComponent]
    });
    fixture = TestBed.createComponent(DepsitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
