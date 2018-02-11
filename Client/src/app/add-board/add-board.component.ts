import { Component, OnInit } from '@angular/core';
import { Board } from '../model/board';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { MainComponentService } from '../main/main.component.service';


@Component({
  selector: 'app-add-board',
  templateUrl: './add-board.component.html',
  styleUrls: ['./add-board.component.css']
})
export class AddBoardComponent implements OnInit {

  private board: Board;

  constructor(private mainComponentService: MainComponentService, private router: Router) { }

  ngOnInit() {
    this.resetGroupToAdd();
  }

  addBoard() {
    this.mainComponentService.addBoard(this.board).subscribe(
      data => {
        this.resetGroupToAdd();
        this.router.navigate(['/main']);
      },
      err => console.error(err)
    );
  }

  resetGroupToAdd() {
    this.board = {
      title: '',

    }
  }


}
