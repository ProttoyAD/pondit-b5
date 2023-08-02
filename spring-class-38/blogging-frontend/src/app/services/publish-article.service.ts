import {Injectable} from "@angular/core";
import {ArticleModel} from "../modules/stories/model/article.model";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PublishArticleService {

  articles ?: ArticleModel[];
  private aeticlesObservable: BehaviorSubject<ArticleModel[]> = new BehaviorSubject<ArticleModel[]>([]);


  saveArticle(article: ArticleModel) : void {
    // @ts-ignore
    this.articles.push(article);
    // @ts-ignore
    this.aeticlesObservable.next(this.articles);
  }

  getArticles() : Observable<ArticleModel[]> {

    // @ts-ignore
    return this.aeticlesObservable.asObservable();
  }


  constructor() {
    this.articles = [];
  }

}
