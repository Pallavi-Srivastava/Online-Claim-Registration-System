import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';

const routes: Routes = [
  // {path:"home-page",component:HomePageComponent},
  {path:"",component:LoginComponent},
  {path:"header",component:HeaderComponent}
  // {path: "landing-page/:id", component: EmployeePayrollFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
