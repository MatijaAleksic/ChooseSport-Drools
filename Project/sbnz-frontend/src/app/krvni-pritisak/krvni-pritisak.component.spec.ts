import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KrvniPritisakComponent } from './krvni-pritisak.component';

describe('KrvniPritisakComponent', () => {
  let component: KrvniPritisakComponent;
  let fixture: ComponentFixture<KrvniPritisakComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KrvniPritisakComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KrvniPritisakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
