import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MycomponentComponent } from './mycomponent/mycomponent.component';
import { MypipePipe } from './mycomponent/mypipe.pipe';

import { ModuleComponentComponent } from './module-component/module-component.component';
import { ViewPendingAdmissionComponent } from './view-pending-admission/view-pending-admission.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { ProfessorComponent } from './professor/professor.component';
import { ReportCardComponent } from './report-card/report-card.component';




@NgModule({
  declarations: [ //need to register angular directives & componenetshere
    AppComponent, MycomponentComponent, MypipePipe, ModuleComponentComponent, ViewPendingAdmissionComponent, HomeComponentComponent, ProfessorComponent, ReportCardComponent 
  ],
  imports: [ //need to import external & internal modules here
    BrowserModule,
    AppRoutingModule,
    FormsModule,HttpClientModule
  ],
  providers: [], //need to register angular services inside providers section
  bootstrap: [AppComponent] //entry point of application
})
export class AppModule { }
