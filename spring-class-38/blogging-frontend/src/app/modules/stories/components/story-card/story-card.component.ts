import {AfterViewChecked, Component, Input, OnInit} from '@angular/core';
import {HighlightService} from "../../../../services/HighlightService";
import {ArticleModel} from "../../model/article.model";

@Component({
  selector: 'app-story-card',
  templateUrl: './story-card.component.html',
  styleUrls: ['./story-card.component.scss']
})
export class StoryCardComponent implements OnInit, AfterViewChecked {
  // javaCode ?: SafeHtml;
  javaCode ?: string;
  @Input() article ?: ArticleModel;
  constructor(private highlightService: HighlightService) {
    this.javaCode =
      `
      public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
      }
      `;
  }

  ngOnInit(): void {
  }

  ngAfterViewChecked(): void {
    this.highlightService.highlightAll();
  }

}
