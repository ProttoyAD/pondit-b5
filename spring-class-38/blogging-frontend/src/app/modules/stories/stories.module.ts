import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StoriesComponent} from "./components/stories/stories.component";
import {StoriesContainerComponent} from './stories-container.component';
import {StoryCardComponent} from "./components/story-card/story-card.component";
import {RouterModule} from "@angular/router";
import { NewStoryComponent } from './components/new-story/new-story.component';
import {InsertCodeModalComponent} from "./insert-code-modal/insert-code-modal.component";
import {FormsModule} from "@angular/forms";

export const routes = [
  {path: '', component: StoriesContainerComponent},
  {path: 'new', component: NewStoryComponent}
];

@NgModule({
  declarations: [
    StoriesContainerComponent,
    StoriesComponent,
    StoryCardComponent,
    NewStoryComponent,
    InsertCodeModalComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    FormsModule,
  ]
})
export class StoriesModule { }
