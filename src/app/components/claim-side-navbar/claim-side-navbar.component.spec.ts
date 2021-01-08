import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimSideNavbarComponent } from './claim-side-navbar.component';

describe('ClaimSideNavbarComponent', () => {
  let component: ClaimSideNavbarComponent;
  let fixture: ComponentFixture<ClaimSideNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimSideNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimSideNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
