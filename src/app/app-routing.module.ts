import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { ClaimSideNavbarComponent } from './components/claim-side-navbar/claim-side-navbar.component';
import { PolicySideNavbarComponent } from './components/policy-side-navbar/policy-side-navbar.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"header",component:HeaderComponent},
  {path:"claim-page",component:ClaimSideNavbarComponent},
  {path:"policy-page",component:PolicySideNavbarComponent}
  
  // {path: "landing-page/:id", component: EmployeePayrollFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
