import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponentComponent } from './home-component/home-component.component';
// import { HomeComponentComponent } from './home-component/home-component.component';
import { ModuleComponentComponent } from './module-component/module-component.component';

import { Customer } from './mycomponent/customer';
import { MycomponentComponent } from './mycomponent/mycomponent.component';
import { ProfessorComponent } from './professor/professor.component';
import { ReportCardComponent } from './report-card/report-card.component';
import { ViewPendingAdmissionComponent } from './view-pending-admission/view-pending-admission.component';
//Define routes here
const routes: Routes = [
  { path : '',redirectTo:'AddCourse', pathMatch:'full' },
  { path : 'AddCourse',component: HomeComponentComponent},
  { path : 'viewcourses',component: ModuleComponentComponent},
  {path : 'getPeddingAddmissions',component: ViewPendingAdmissionComponent},
  {path : 'addProfessor',component: ProfessorComponent},
  {path : 'report',component: ReportCardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
