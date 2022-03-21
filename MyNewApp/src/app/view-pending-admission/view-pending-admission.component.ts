import { Component, OnInit } from '@angular/core';
import { MyserviceService } from '../myservice.service';
import { Student } from '../student';

@Component({
  selector: 'app-view-pending-admission',
  templateUrl: './view-pending-admission.component.html',
  styleUrls: ['./view-pending-admission.component.css']
})
export class ViewPendingAdmissionComponent implements OnInit {

  getData: any;
   Student= new Student();
  ngOnInit(): void {
  }
  constructor(private _httpService: MyserviceService) {
    this.getPeddingAddmissions();
  }
//  today =new Date();

getPeddingAddmissions(){
  this._httpService.getPeddingAddmissions().subscribe((res : any[])=>{
           console.log(res);
           this.getData = res;
});
}

approveStudent(studentId:string){
  
  this._httpService.approveStudent(studentId).subscribe((res : any)=>{
           console.log(res);
           this.getData = res;
});
}

}
