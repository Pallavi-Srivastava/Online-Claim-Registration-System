import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'policy-side-navbar',
  templateUrl: './policy-side-navbar.component.html',
  styleUrls: ['./policy-side-navbar.component.scss']
})
export class PolicySideNavbarComponent implements OnInit {

  firstButton: string = "Policy Creation";
  secondButton: string = "View Policies";
  thirdButton: string = "Update Policy";

  constructor() { }

  ngOnInit(): void {
  }

}
