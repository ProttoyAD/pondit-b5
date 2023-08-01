import {AfterViewInit, Component, OnInit} from '@angular/core';
import {InsertCodeModel} from "../../model/insert-code.model";

@Component({
  selector: 'app-new-story',
  templateUrl: './new-story.component.html',
  styleUrls: ['./new-story.component.scss']
})
export class NewStoryComponent implements OnInit, AfterViewInit{

  articleContent ?: string
  tempFiles ?: string[] = [];

  summernote?: any

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {

    // @ts-ignore
    let publishButton = function (context) {
      // @ts-ignore
      let ui = $.summernote.ui;

      function publishArticle(summernote1: any) {
        console.log(summernote1)
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
        ['Publish this Article', ['publishButton']],
        ['Save as Deaft', ['saveAsDraft']],
      ],
      buttons: {
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
        onToolbarClick: function(e: any) {
          // Get the clicked button's data-value attribute
          // @ts-ignore
          var buttonValue = $(e.target).data('value');

          // Prevent the default behavior for the "Code" button
          if (buttonValue === 'code') {
            e.preventDefault();
          }
        }
      }
    })



    let currentContext = this.summernote.closest('app-new-story')
    let imgBtn = currentContext.find('[aria-label=pre]')
      .on("click", function(evt: any) {
        evt.preventDefault();
        let codeEditor = currentContext.find('.code-editor-modal');
        codeEditor.modal('show')
    })

    // @ts-ignore

  }

  triggerCodeInsert($event: InsertCodeModel) {
    let content =`<pre><code class="language-${$event.codeLanguage}">${$event.codeContent}</code></pre>` ;
    let existingContent = this.summernote.summernote('code'); // Get the existing content
    // @ts-ignore
    let $content = $(existingContent);
    // Combine the existing content with the new content
    let lastElement = $content[$content.length - 1];
    // @ts-ignore
    if (lastElement.localName === `pre` && !$(lastElement).text()) {
      // @ts-ignore
      $($content[$content.length - 1]).html(`<code class="language-${$event.codeLanguage}">${$event.codeContent}</code>`)
      this.summernote.summernote('code', $content);
    }
  }
}
