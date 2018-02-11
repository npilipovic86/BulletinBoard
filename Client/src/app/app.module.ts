import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { Routes, RouterModule } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorService } from './service/token-interceptor.service';
import { AuthenticationService } from './service/authentication.service';
import { JwtUtilsService } from './service/jwt-utils.service';
import { CanActivateAuthGuard } from './service/can-activate-auth.guard';
import { GroupService } from './service/board.service';
import { MainComponentService } from './main/main.component.service';
import { BoardPreviewComponent } from './board-preview/board-preview.component';

import { AddBoardComponent } from './add-board/add-board.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainComponent },
  { path: 'addBoard', component: AddBoardComponent },
  { path: 'boards/:id', component: BoardPreviewComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: '**', component: PagenotfoundComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    PagenotfoundComponent,
    AddBoardComponent,
    LoginComponent,
    MainComponent,
    BoardPreviewComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false
      }
    )
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService,
    GroupService, MainComponentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
