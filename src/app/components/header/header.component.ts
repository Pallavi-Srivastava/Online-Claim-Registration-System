import { UserService } from 'src/app/services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  [x: string]: any;

  constructor(private userService: UserService) {
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
