import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {AppComponent} from "./app.component";

export const routes = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path: 'stories', loadChildren: () => import('./modules/stories/stories.module').then(m => m.StoriesModule)},
  {path: '**', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
