import {AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-insert-code-modal',
  templateUrl: './insert-code-modal.component.html',
  styleUrls: ['./insert-code-modal.component.scss']
})
export class InsertCodeModalComponent implements OnInit, AfterViewInit {

  selectedLanguage ?: string

  @ViewChild('selectCodeLanguage') selectCodeLanguage ?: ElementRef<HTMLInputElement>;

  constructor(private elementRef: ElementRef) {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
    const componentRef = this;
    // @ts-ignore
    $(this.selectCodeLanguage.nativeElement).select2({
      theme: 'bootstrap4'
    });
    // @ts-ignore
    $(this.selectCodeLanguage.nativeElement).on('select2:select', function (e) {
      componentRef.selectedLanguage = e.params.data.id
      console.log(componentRef.selectedLanguage)
    });
  }
}
