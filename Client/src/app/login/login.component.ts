import { Component, OnInit } from '@angular/core'; 
import { Router } from '@angular/router'; 
import { Observable } from 'rxjs/Observable'; 
import { AuthenticationService } from '../service/authentication.service'; 
 
@Component({ 
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
}) 
export class LoginComponent implements OnInit { 
public user; 

public wrongUsernameOrPass:boolean; 

constructor(private authenticationService:AuthenticationService, 
 private router: Router) { 
 this.user = {}; 
 this.wrongUsernameOrPass = false; 
} 

ngOnInit() { 
} 

login():void{ 
 this.authenticationService.login(this.user.username, this.user.password).subscribe( 
   (loggedIn:boolean) => { 
     if(loggedIn){ 
       this.router.navigate(['/main']);           
     } 
   } 
 , 
 (err:Error) => { 
   if(err.toString()==='Ilegal login'){ 
     this.wrongUsernameOrPass = true; 
     console.log(err); 
   } 
   else{ 
     Observable.throw(err); 
   } 
 }); 
} 
}