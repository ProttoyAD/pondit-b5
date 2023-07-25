import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {AppComponent} from "./app.component";
import {SecuredComponent} from "./components/secured/secured.component";
import {StoriesComponent} from "./components/stories/stories.component";

export const routes = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path: 'secured', component: SecuredComponent},
  {path: 'stories', component: StoriesComponent},
  {path: '**', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
