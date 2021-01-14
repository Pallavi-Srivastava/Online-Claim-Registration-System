import { Injectable } from '@angular/core';
import { CanActivateChild, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, CanActivate } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthService } from './auth.service';
const helper=new JwtHelperService();

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivateChild,CanActivate {

  constructor(private authService: AuthService,private router: Router) { }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | import("@angular/router").UrlTree | Observable<boolean | import("@angular/router").UrlTree> | Promise<boolean | import("@angular/router").UrlTree> {
    return this.authService.isAuthorised();
  }
  canActivate(){
    return this.authService.isAuthorised();
  }
}
