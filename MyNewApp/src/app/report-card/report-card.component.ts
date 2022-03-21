import { Component, OnInit } from '@angular/core';
import { MyserviceService } from '../myservice.service';
import { RegisteredCourse } from '../registered-course';

@Component({
  selector: 'app-report-card',
  templateUrl: './report-card.component.html',
  styleUrls: ['./report-card.component.css']
})
export class ReportCardComponent implements OnInit {

  getData: any;
  model = new RegisteredCourse('','','');
  // RegisteredCourse= new RegisteredCourse();
 ngOnInit(): void {
 }
 constructor(private _httpService: MyserviceService) {
   this.reportCard();
 }
//  today =new Date();

reportCard(){
 this._httpService.reportCard().subscribe((res : any[])=>{
          console.log(res);
          this.getData = res;
});
}




}
