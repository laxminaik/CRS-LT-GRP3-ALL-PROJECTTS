import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //need to define all the modules and comp here
  title = 'CRS Admin';
  today = new Date();
  id=0;
}
