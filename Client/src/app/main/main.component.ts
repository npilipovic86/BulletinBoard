import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { MainComponentService } from './main.component.service';
import { Message } from '../model/message';
import { Board } from '../model/board';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  id: number;
  boards: Array<Board>;
  messages: Message[];




  constructor(private boardService: MainComponentService,
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.boardService.getBoards().subscribe(data => {
      this.boards = data;
    })
    this.http.get(`api/messages`).subscribe(
      (res: any) => {
        this.messages = res;

      }
    )
  }

  isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  isAdmin(): boolean {
    return this.authenticationService.isAdmin();
  }

  deleteBoard(b: Board) {
    this.boardService.deleteBoard(b).subscribe(
      () => {
        this.loadData();
      }
    )
  }

}
