import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicySideNavbarComponent } from './policy-side-navbar.component';

describe('PolicySideNavbarComponent', () => {
  let component: PolicySideNavbarComponent;
  let fixture: ComponentFixture<PolicySideNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PolicySideNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PolicySideNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
