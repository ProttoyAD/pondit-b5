import {AfterViewInit, Component, OnInit} from '@angular/core';
import {InsertCodeModel} from "../../model/insert-code.model";
import {ArticleModel} from "../../model/article.model";
import {PublishArticleService} from "../../../../services/publish-article.service";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-new-story',
  templateUrl: './new-story.component.html',
  styleUrls: ['./new-story.component.scss']
})
export class NewStoryComponent implements OnInit, AfterViewInit{

  tempFiles ?: string[] = [];

  summernote ?: any

  constructor(
    private publishArticleService: PublishArticleService
    , private domSanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    let $this = this;
    // @ts-ignore
    let insertCode = function (context) {
      // @ts-ignore
      let ui = $.summernote.ui;
      // create button
      let button = ui.button({
        contents: '<b>{..}</b>',
        tooltip: 'Insert Code',
        click: function () {
          // invoke insertText method with 'hello' on editor module.
          // @ts-ignore
          let currentContext = $('.summernote').closest('app-new-story')
          let codeEditor = currentContext.find('.code-editor-modal');
          codeEditor.modal('show')
        }
      });
      return button.render();
    }

    // @ts-ignore
    let publishButton = function (context) {
      // @ts-ignore
      let ui = $.summernote.ui;

      function publishArticle(summernote1: string) {
        let article = new ArticleModel();
        article.content = summernote1;
        article.published = true;
        console.log(article);
        $this.domSanitizer.bypassSecurityTrustHtml(article.content);
        $this.publishArticleService.saveArticle(article);
      }

      // create button
      let button = ui.button({
        contents: 'Publish Article&nbsp;&nbsp;<i class="fa fa-paper-plane"></i>',
        tooltip: 'Publish Article',
        click: function () {
          // invoke insertText method with 'hello' on editor module.
          // @ts-ignore
          publishArticle($('.summernote').summernote('code'))
        }
      });

      return button.render();   // return button as jquery object
    }

    // @ts-ignore
    let saveAsDraft = function (context) {
      // @ts-ignore
      let ui = $.summernote.ui;

      // create button
      let button = ui.button({
        contents: '<i class="fa fa-floppy-o">Save as Deaft</i>',
        tooltip: 'Save as Deaft',
        click: function () {
          // invoke insertText method with 'hello' on editor module.
          context.invoke('editor.insertText', 'hello');
        }
      });

      return button.render();   // return button as jquery object
    }

    // @ts-ignore
    this.summernote = $('.summernote').summernote( {
      // @ts-ignore
      height: $(window).height() * 0.7,
      escapeHTML: false,
      lang: 'en-US',
      toolbar: [
        ['style'],
        ['textstyle', ['bold', 'italic', 'underline', 'clear']],
        ['font', ['strikethrough', 'superscript', 'subscript']],
        ['fontsize', ['fontsize']],
        ['color', ['forecolor', 'backcolor']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['insert', ['picture', 'link', 'table', 'hr']],
        ['misc', ['fullscreen', 'codeview', 'undo', 'redo']],
        ['Insert Code', ['insertCode']],
        ['Publish this Article', ['publishButton']],
        ['Save as Deaft', ['saveAsDraft']],
      ],
      buttons: {
        insertCode: insertCode,
        publishButton: publishButton,
        saveAsDraft: saveAsDraft
      },

      callbacks: {
        onImageUpload: function (files: any) {
          console.log(files)
          let url = URL.createObjectURL(files[0])
          let image = new Image();
          image.src = url;
          let fileUniqueName = files[0].lastModified + '_' + files[0].name;
          console.log(fileUniqueName)
          // tempFiles.push(fileUniqueName)
          // @ts-ignore
          $('.summernote').summernote ("insertImage", url);
        },
      }
    });


    // @ts-ignore

  }

  triggerCodeInsert($event: InsertCodeModel) {
    let content = `
    <pre style="tab-size: 4; border: 1px grey solid;background-color: #eeeeee;">
        <code class='language-${$event.codeLanguage}'>${$event.codeContent}</code>
    </pre>
    <br>
    ` ;
    let existingContent = this.summernote.summernote('code'); // Get the existing content

    // @ts-ignore
      this.summernote.summernote('code', existingContent + content);
      this.summernote.summernote('font', 'Arial')
  }
}
