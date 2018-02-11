import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { AuthenticationService } from './authentication.service';
import { Board } from '../model/board';

@Injectable()
export class GroupService {

    readonly path = "api/boards";

    constructor(private httpClient: HttpClient, private authService: AuthenticationService) { }

    saveBoard(group: Board): Observable<any> {
        return this.httpClient.post(this.path, group);
    }

}