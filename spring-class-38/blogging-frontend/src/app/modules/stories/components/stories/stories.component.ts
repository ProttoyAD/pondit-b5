import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import {PublishArticleService} from "../../../../services/publish-article.service";
import {ArticleModel} from "../../model/article.model";

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.scss']
})
export class StoriesComponent implements OnInit {

  articles: ArticleModel[] = [];
  constructor(
    private publishArticleService: PublishArticleService
    , private domSanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    setInterval(() => {
      this.publishArticleService.getArticles().subscribe(value => {
          this.articles = value
          // this.articles.forEach(article => {
          //   // @ts-ignore
          //   article.content = article.content
          // })
        })
    }, 1000);
  }

}
