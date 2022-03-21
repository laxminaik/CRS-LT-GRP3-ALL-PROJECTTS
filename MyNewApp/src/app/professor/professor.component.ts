import { Component, OnInit } from '@angular/core';
import { MyserviceService } from '../myservice.service';
// import { MyserviceService } from '../myservice.service';
import { Professor } from '../professor';
@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {

  model = new Professor('','','');

  constructor(private _httpService: MyserviceService) {
   
  }

  ngOnInit(): void {
  }

  addProfessor(model:any): void {
    this._httpService.addProfessor(model)
      .subscribe((res : any) => {
          console.log(res);
        console.log ('The professor was added!');
        }
        );
  }

}
