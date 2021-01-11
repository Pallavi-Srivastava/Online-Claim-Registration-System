import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-account-number',
  templateUrl: './account-number.component.html',
  styleUrls: ['./account-number.component.scss']
})
export class AccountNumberComponent implements OnInit {

  userObj: User =new User();

  profileForm: any;
  userId: any;
  isUpdate = false;
  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this. profileForm = this.formBuilder.group({
      userName: ['', Validators.required],
      id: ['']
    });

    this.activatedRoute.params.subscribe(data => {
      if (data && data.id) {
        //for required  Validation
       // this.getDataById(data.id)
      }
    })

  }

  ngOnInit(): void {
  }
  onSubmit() {
    console.log("save");

      // this.userService.addAddressookRecord(this.userObj).subscribe(response => {
      //   console.log("response is ", response);
      //   this.router.navigateByUrl('');
      // }, err => {
      // })
    }
  
  reset(): void {
    this.profileForm.reset();
  }
}
