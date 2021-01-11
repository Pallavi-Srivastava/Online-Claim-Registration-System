import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterPolicyComponent } from './register-policy.component';

describe('RegisterPolicyComponent', () => {
  let component: RegisterPolicyComponent;
  let fixture: ComponentFixture<RegisterPolicyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterPolicyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterPolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
