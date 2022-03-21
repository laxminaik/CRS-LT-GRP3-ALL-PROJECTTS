import { Component, OnInit } from '@angular/core';
import { Customer } from './customer';
import { MyserviceService } from './myservice.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-mycomponent',
  templateUrl: './mycomponent.component.html',
  styleUrls: ['./mycomponent.component.css']
})
export class MycomponentComponent implements OnInit {
  id=0;
  // define Customer Array as model to get values here 
  custArray: Array<Customer> = new Array();
 
  // define back model here 
 
  model = new Customer('', 0);
  noRecords: boolean = true;
  age: any;
  updateNeeded: boolean=false;
  name: any;
  cust = {
    name: '',
    age: ''
  };
  submitted = false;

 // define object 

 getData:any;
  url: any;


 getUser(){

  this._httpService.getUserDetails().subscribe((res : any[])=>{
           console.log(res);
           this.getData = res;

});
let i = this.model.age;
console.log(i);
if(i!=NaN){
this.noRecords=false;
}
}




 constructor(private _httpService: MyserviceService) {


}
  ngOnInit(): void {
    this._httpService.getUserDetails().subscribe((data)=>{
      console.log(data);
      this.cust=data;
    })
  }
  
onSubmit(){
  console.log(this.model);
  this._httpService.enroll(this.model).subscribe(
    (    data: any)=>console.log('Sucess',data),
    (error :any)=>console.log("Error",error)
  )
}
deleteRow(val:any){
  console.log('val is---',val);
  this._httpService.deleteUser(val).subscribe( (    data: any)=> {
    
  }
);
}
updateRow(){
  console.log("HII");
   var s=this.model.name ;
  var p =this.model.age ;
  console.log(s);
  console.log( p);
  this._httpService.updateUser(this.name,this.age).subscribe((data:any)=>{
    console.log(data);
  });
}
///////////////////////////////////////
  createCustomer() {
    console.log("customer creation here-->");
    try {
      // Add customer in Customer Array using push event.
      this.custArray.push(new Customer(this.model.name, this.model.age));
      console.log(JSON.stringify(this.custArray));
    } catch (err) {
      console.log("customer creation here-->" + err);
  }
  }
  updateCustomer() {
    try {
      let i = this.custArray.indexOf(this.model);

      if (i !== -1) {
        this.custArray[i].name = this.name;
        this.custArray[i].age = this.age;
        this.updateNeeded = false;
        console.log("Okay " + this.name + "! Details updated successfully");
      }
    } catch (err) {
      console.log("customer edit error-->" + err);
    }
  }
  public deleteCustomer(index :number){
    console.log("Array Index " + index);
    
    this.custArray = this.newArray(this.custArray ,index);
    
    
    
    }
    
    
    
    public newArray(array: Array<Customer>,indexValue:number):Array<Customer>{
    
    let newArray: Array<Customer> = new Array();
    
    
    // define back model here
    
    
    
    let customer = new Customer('', 0);
    
    
    
    for (let index = 0; index < array.length; index++) {
    
    
    
    if(index != indexValue){
    customer.age=array[index].age;
    customer.name=array[index].name;
    
    
    
    newArray.push(new Customer(customer.name, customer.age));
    
    }
    }
    return newArray;
    
    }
    
  
  
  editCustomer(id:any){
    console.log
    this.updateNeeded = true;
    this.id=id;
  }
  }
  

