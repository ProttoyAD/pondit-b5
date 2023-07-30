import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-new-story',
  templateUrl: './new-story.component.html',
  styleUrls: ['./new-story.component.scss']
})
export class NewStoryComponent implements OnInit, AfterViewInit{

  articleContent ?: string
  tempFiles ?: string[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {

    // @ts-ignore
    let publishButton = function (context) {
      // @ts-ignore
      let ui = $.summernote.ui;

      // create button
      let button = ui.button({
        contents: 'Publish Article&nbsp;&nbsp;<i class="fa fa-paper-plane"></i>',
        tooltip: 'Publish Article',
        click: function () {
          // invoke insertText method with 'hello' on editor module.
          context.invoke('editor.insertText', 'hello');
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
    let summernote = $('.summernote').summernote( {
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
      }
    })



    let currentContext = summernote.closest('app-new-story')
    let imgBtn = currentContext.find('[aria-label=pre]')
      .on("click", function(evt: any) {
        let codeEditor = currentContext.find('.code-editor-modal');
        codeEditor.modal('show')
        // @ts-ignore
        $('.select2bs4').select2({
          theme: 'bootstrap4'
        });
        codeEditor.find('.save-code').on('click', function () {
          let textArea = codeEditor.find('textarea');
          let content =`<pre><code class="language-java">${textArea.val()}<code><pre>` ;
          let existingContent = summernote.summernote('code'); // Get the existing content

          // Combine the existing content with the new content
          let combinedContent = existingContent + content;

          // Set the combined content back to Summernote
          summernote.summernote('code', combinedContent);
        })
    })

    // @ts-ignore

  }

}
