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
    let summernote = $('.summernote').summernote( {

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
    // @ts-ignore
    let currentContext = summernote.closest('app-new-story')
    let imgBtn = currentContext.find('[aria-label=pre]')
      .on("click", function(evt: any) {
        let codeEditor = currentContext.find('.code-editor-modal');
        codeEditor.modal('show')
        codeEditor.find('.save-code').on('click', function () {
          let textArea = codeEditor.find('textarea');
          let content =`<pre><code class="language-java">${textArea.val()}<code><pre>` ;
          var existingContent = summernote.summernote('code'); // Get the existing content

          // Combine the existing content with the new content
          var combinedContent = existingContent + content;

          // Set the combined content back to Summernote
          summernote.summernote('code', combinedContent);
        })
    })
    console.log(imgBtn)
    // imgBtn.on('click', (evt: any) => {
    //   console.log(evt)
    // })
    // imgBtn.off('click').on('click', function(evt) {
    //
    //   $('imageDialog.show').show();
    // })
  }

}
