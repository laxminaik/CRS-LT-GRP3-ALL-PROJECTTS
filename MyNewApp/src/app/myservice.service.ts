import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Course } from './course';
import { Professor } from './professor';

@Injectable({
  providedIn: 'root'
})
export class MyserviceService {
  

  // deleteCourse(courseCode : CourseCode) {
  //   console.log("course code is:"+courseCode);
  //   throw new Error('Method not implemented.');
  // }

  constructor(private http:HttpClient) { }
  /**
   * 
   * @param data 
   * @returns 
   */

  addCourse(course: any):Observable<Course>  {
    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
    
  return  this.http.post<Course>('http://javafulstack-79.alchemycloud.co.in:8091/admin/addCourse',course,httpOptions);

  }

  addProfessor(professor: any):Observable<Professor>  {
    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
    
  return  this.http.post<Professor>('http://javafulstack-79.alchemycloud.co.in:8091/admin/addProfessor',professor,httpOptions);

  }

 

  getCourses(): Observable<any> {
    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
         return this.http.get
           <any>('http://javafulstack-79.alchemycloud.co.in:8091/admin/courses',httpOptions);         
       }


getPeddingAddmissions(): Observable<any> {
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
       return this.http.get
         <any>('http://javafulstack-79.alchemycloud.co.in:8091/admin/viewPendingAdmissions',httpOptions);         
     }

     deleteCourse(courseCode: string): Observable<any> {
     
      const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
      return this.http.delete<any>('http://javafulstack-79.alchemycloud.co.in:8091/admin/deleteCourse?courseCode='+courseCode,httpOptions);         
    }
  
    approveStudent(studentId: string): Observable<any> {
     
      const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
      return this.http.post<any>('http://javafulstack-79.alchemycloud.co.in:8091/admin/approve?studentId='+studentId,httpOptions);         
    }

    reportCard(): Observable<any> {
      const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
           return this.http.get
             <any>('http://javafulstack-79.alchemycloud.co.in:8091/admin/generateReport',httpOptions);         
         }

 


}
