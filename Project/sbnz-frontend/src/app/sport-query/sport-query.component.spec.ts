import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SportQueryComponent } from './sport-query.component';

describe('SportQueryComponent', () => {
  let component: SportQueryComponent;
  let fixture: ComponentFixture<SportQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SportQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SportQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
