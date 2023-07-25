import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './components/login/login.component';
import { SecuredComponent } from './components/secured/secured.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ContentWrapperComponent } from './components/content-wrapper/content-wrapper.component';
import { ContentComponent } from './components/content/content.component';
import { ContentHeaderComponent } from './components/content-header/content-header.component';
import { StoryCardComponent } from './components/story-card/story-card.component';
import { StoriesComponent } from './components/stories/stories.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SecuredComponent,
    NavbarComponent,
    ContentWrapperComponent,
    ContentComponent,
    ContentHeaderComponent,
    StoryCardComponent,
    StoriesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
