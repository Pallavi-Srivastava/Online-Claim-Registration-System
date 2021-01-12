import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'claim-side-navbar',
  templateUrl: './claim-side-navbar.component.html',
  styleUrls: ['./claim-side-navbar.component.scss']
})
export class ClaimSideNavbarComponent implements OnInit {

  firstButton: string = "Claim Creation";
  secondButton: string = "View Claim";
  thirdButton: string = "Report Generation";
  fourthButton: string = "New Profile Creation";
  fifthButton: string = "View Available Policies";
  sixthButton: string = "Create Policy";

  @Input("roleCode") public roleCode: string;  

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

}
