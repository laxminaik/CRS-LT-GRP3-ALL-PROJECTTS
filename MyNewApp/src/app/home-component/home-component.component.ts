import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { MyserviceService } from '../myservice.service';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css']
})
export class HomeComponentComponent implements OnInit {

  getCourseList:Array<Course>=[];//check 

  model = new Course('','','',0);

  //model = new Course();
  noRecords: boolean = true;
  age: any;
  updateNeeded: boolean=false;
  name: any;
  cust = {
    courseCode: '',
    courseName: '',
    instructorId: '',
    availableSeats: ''
  };
  submitted = false;
 ngOnInit(): void {
 }
 constructor(private _httpService: MyserviceService) {
   
 }


addCourse(model:any): void {
   this._httpService.addCourse(model)
     .subscribe((res : any) => {
         console.log(res);
       console.log ('The product was updated!');
       }
       );
 }



}



