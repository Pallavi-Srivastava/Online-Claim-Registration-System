import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimCreationComponent } from './claim-creation.component';

describe('ClaimCreationComponent', () => {
  let component: ClaimCreationComponent;
  let fixture: ComponentFixture<ClaimCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
