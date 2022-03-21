import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { MyserviceService } from '../myservice.service';

@Component({
  selector: 'app-module-component',
  templateUrl: './module-component.component.html',
  styleUrls: ['./module-component.component.css']
})
export class ModuleComponentComponent implements OnInit {
  getData: any;
 
  ngOnInit(): void {
  }
  constructor(private _httpService: MyserviceService) {
    this.getCourses();
  }
  getCourses(){
    this._httpService.getCourses().subscribe((res : any[])=>{
             console.log(res);
             this.getData = res;
  });
}


deleteCourse(courseCode:string){
  debugger
  this._httpService.deleteCourse(courseCode).subscribe((res : any)=>{
           console.log(res);
           this.getData = res;
});
}



}
