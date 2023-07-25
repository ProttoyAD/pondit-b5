import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StoriesComponent} from "./components/stories/stories.component";
import {StoriesContainerComponent} from './stories-container.component';
import {StoryCardComponent} from "./components/story-card/story-card.component";
import {RouterModule} from "@angular/router";
import { NewStoryComponent } from './components/new-story/new-story.component';

export const routes = [
  {path: '', component: StoriesContainerComponent},
  {path: 'new', component: NewStoryComponent}
];

@NgModule({
  declarations: [
    StoriesContainerComponent,
    StoriesComponent,
    StoryCardComponent,
    NewStoryComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule
  ]
})
export class StoriesModule { }
