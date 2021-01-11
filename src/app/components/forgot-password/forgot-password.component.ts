import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  userObj: User = new User();

  loginForm: any;
  userId: any;
  validation:boolean;
  emailError: string="";
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. loginForm= this.formBuilder.group({
      email: ['', Validators.required],
      id: ['']
    });
  }

  ngOnInit() {
  }

  onEmailChange() {
    let emailRegex = RegExp('^([a-z0-9]+[-._+]?[a-z0-9]+)+@[a-z0-9-]+.[a-z]{2,3}.[a-z]{2,3}$');
    if (emailRegex.test(this.userObj.email)){
        this.emailError = "";
        this.validation=true;
    } else {
        this.emailError = 'Invalid email';
        this.validation=false;
    }
  }

  onSubmit() {
    if(!this.validation){
      console.log(this.validation);//false
      return ;
    }
      this.userService.forgotPassword(this.userObj).subscribe(response => {
        console.log("response is ", response);
        alert("We have e-mailed your password reset link");
        this.router.navigateByUrl('');
      }, err => {
      })
  }

}
