import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { RequestOptions, Headers } from '@angular/http';
import { MainComponent } from './main.component';
import { Observable } from 'rxjs';
import { Params } from '@angular/router';
import { Board } from '../model/board';

@Injectable()
export class MainComponentService {
  private id: number;

  readonly path = 'api/boards';

  constructor(private httpClient: HttpClient) {
  }

  getBoards(): Observable<Board[]> {
    return this.httpClient.get(this.path) as Observable<Board[]>;
  }

  getBoard(id: number): Observable<Board> {
    return this.httpClient.get(this.path) as Observable<Board>;
  }

  deleteBoard(b: Board) {
    return this.httpClient.delete(this.path + '/' + b.id);
  }

  addBoard(b: Board): Observable<Board> {
    return this.httpClient.post(this.path, b) as Observable<Board>;
  }
}

