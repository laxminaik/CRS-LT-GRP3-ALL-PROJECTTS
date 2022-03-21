import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';


@Injectable({
  providedIn: 'root'
})
export class MyserviceService {
  headers=new HttpHeaders().set('Content-Type','application/json').set('Accept','application/json');
  httpOptions={
    headers: this.headers
  }
  url= ' http://localhost:7000/users/delete ';

  constructor(private http:HttpClient) {
   // this.url = "http://localhost:7000.com";
  }
  enroll(cust:Customer){
    return this.http.post<any>('http://localhost:7000/users/',cust);
  }
  getUserDetails(): Observable<any> {
    return this.http.get(
      'http://localhost:7000/users'
    );
  }
  
 deleteUser(id:any): Observable<any> {
   const url='${this.url}/${id}';
   console.log('${this.url}/${id}');
   return this.http.delete<any>(' http://localhost:7000/users/delete/'+id,this.httpOptions);
 }
 updateUser(id:any, cust:Customer): Observable<any> {
   return this.http.put<any>(' http://localhost:7000/users/update/'+id,this.httpOptions) 
 }

}
