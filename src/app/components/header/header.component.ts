import { UserService } from 'src/app/services/user.service';
import { Component, OnInit } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  [x: string]: any;

  constructor(private userService: UserService,private breakpointObserver: BreakpointObserver, private router : Router)  {
   }

  ngOnInit(): void {
  }

  onLogOut(){
    console.log("exit");
      this.userService.logOut().subscribe(response => {
        console.log("response is ", response);
        localStorage.clear();
        alert("You have successfully logged out!!")
        this.router.navigateByUrl('');
      }, err => {
      })
    }
}
