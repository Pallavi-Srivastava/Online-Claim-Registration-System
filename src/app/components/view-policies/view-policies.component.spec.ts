import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPoliciesComponent } from './view-policies.component';

describe('ViewPoliciesComponent', () => {
  let component: ViewPoliciesComponent;
  let fixture: ComponentFixture<ViewPoliciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPoliciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPoliciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
