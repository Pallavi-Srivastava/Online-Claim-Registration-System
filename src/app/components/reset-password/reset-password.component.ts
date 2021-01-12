import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ResetPassword } from 'src/app/models/reset-password';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})
export class ResetPasswordComponent implements OnInit {

  resetObj: ResetPassword = new ResetPassword();
  validation:boolean;
  newPasswordError: string="";
  confirmPasswordError: string="";
  resetForm: any;
  userId: any;
  token:any;
  data:any;
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. resetForm= this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      id: ['']
    });
  }

  ngOnInit() {
  }

  onNewPasswordChange() {
    const passwordRegex = RegExp('^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$');
    if (passwordRegex.test(this.resetObj.newPassword)){
        this.newPasswordError = "";
        this.validation=true;
     } else {
        this.newPasswordError = 'Invalid Password.';
        this.validation=false;
     }
  }

  onConfirmPasswordChange() {
    const passwordRegex = RegExp('^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$');
    if (passwordRegex.test(this.resetObj.confirmPassword)){
        this.confirmPasswordError = "";
        this.validation=true;
    } else {
        this.confirmPasswordError = 'Invalid Password.';
        this.validation=false;
    }
  }

  onSubmit() {
    if(!this.validation){
      console.log(this.validation);//false
      return ;
    }
    console.log("save");
      this.data=JSON.parse(localStorage.getItem("token"));
      this.userService.resetPassword(this.resetObj,this.data).subscribe(response => {
        console.log("response is ", response);
        alert("Password update Successful!! You can now login to your Account with the new password");
        this.router.navigateByUrl('');
      }, err => {
      })
  }
}
