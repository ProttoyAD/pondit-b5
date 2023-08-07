import {AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {InsertCodeModel} from "../../model/insert-code.model";

@Component({
  selector: 'app-insert-code-modal',
  templateUrl: './insert-code-modal.component.html',
  styleUrls: ['./insert-code-modal.component.scss']
})
export class InsertCodeModalComponent implements OnInit, AfterViewInit {

  selectedLanguage ?: string

  @ViewChild('selectCodeLanguage') selectCodeLanguage ?: ElementRef<HTMLInputElement>;
  @ViewChild('insertCodeModal') insertCodeModal ?: ElementRef<HTMLInputElement>;
  codeContent ?: string;

  @Output() insertCodeEvent = new EventEmitter<InsertCodeModel>();

  constructor() {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
    const $this = this;
    // @ts-ignore
    $(this.selectCodeLanguage.nativeElement).select2({
      theme: 'bootstrap4'
    });
    // @ts-ignore
    $(this.selectCodeLanguage.nativeElement).on('select2:select', function (e) {
      $this.selectedLanguage = e.params.data.id
    });
  }

  insertCode() {
    let insertCodeModel = new InsertCodeModel();
    insertCodeModel.codeContent = this.codeContent
    insertCodeModel.codeLanguage = this.selectedLanguage
    this.insertCodeEvent.emit(insertCodeModel)
    // @ts-ignore
    const insertCodeModal = $('.code-editor-modal');
    insertCodeModal.modal('hide');
    this.codeContent = ''

    // @ts-ignore
    insertCodeModal.find("code:not([class^='language-'])").closest('pre').remove();
  }
}
