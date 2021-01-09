import { ProfileCreationComponent } from './components/profile-creation/profile-creation.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { ClaimSideNavbarComponent } from './components/claim-side-navbar/claim-side-navbar.component';
import { PolicySideNavbarComponent } from './components/policy-side-navbar/policy-side-navbar.component';
import { ClaimCreationComponent } from './components/claim-creation/claim-creation.component';
import { ViewPoliciesComponent } from './components/view-policies/view-policies.component';
import { ReportGenerationComponent } from './components/report-generation/report-generation.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"header",component:HeaderComponent},
  {path:"profile-creation",component:ProfileCreationComponent},
  {path:"claim-creation",component:ClaimCreationComponent},
  {path:"claim-page",component:ClaimSideNavbarComponent},
  {path:"policy-page",component:PolicySideNavbarComponent},
  {path:"view-policies",component:ViewPoliciesComponent},
  {path:"report-generation",component:ReportGenerationComponent}
  // {path: "landing-page/:id", component: EmployeePayrollFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
