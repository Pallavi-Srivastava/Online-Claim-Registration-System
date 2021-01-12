import { Component, OnInit } from '@angular/core';
import { LocationStrategy } from '@angular/common';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  roleCode:any;

  ngOnInit(): void {

    this.roleCode=JSON.parse(localStorage.getItem("RoleCode"));

  }

}
