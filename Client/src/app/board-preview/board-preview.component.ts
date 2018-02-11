import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Board } from '../model/board';
import { Message } from '../model/message';
import { User } from '../model/user';

@Component({
  selector: 'app-board-preview',
  templateUrl: './board-preview.component.html',
  styleUrls: ['./board-preview.component.css']
})
export class BoardPreviewComponent implements OnInit {

  text: string;
  user: User;
  private id: number;

  board: Board;
  messages: Message[] = [];
  createDateTime: Date;

  private messageToAdd: Message = {
    text: '',
    createDateTime: null

  };

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.loadData();

  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = +param['id'];
      this.http.get(`api/boards/${this.id}/messages`).subscribe(
        (res: any) => {
          this.messages = res;
        }
      )
    })
    this.route.params.subscribe(param => {
      this.id = +param['id'];
      this.http.get(`api/boards/${this.id}`).subscribe(
        (res: any) => {
          this.board = res;
        }
      )
    })
  }

  addMessage() {
    this.messageToAdd.text = this.text;
    this.messageToAdd.createDateTime = this.createDateTime;
    this.http.post(`api/boards/${this.id}/messages`, this.messageToAdd).subscribe(
      (res: Response) => {
        this.resetMessageToAdd();
        this.loadData();
      })
  }

  resetMessageToAdd() {
    this.text = "";

  }



}
