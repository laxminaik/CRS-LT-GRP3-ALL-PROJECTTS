import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPendingAdmissionComponent } from './view-pending-admission.component';

describe('ViewPendingAdmissionComponent', () => {
  let component: ViewPendingAdmissionComponent;
  let fixture: ComponentFixture<ViewPendingAdmissionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPendingAdmissionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPendingAdmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
