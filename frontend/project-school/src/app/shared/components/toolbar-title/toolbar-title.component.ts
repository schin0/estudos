import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-toolbar-title',
  templateUrl: './toolbar-title.component.html',
  styleUrls: ['./toolbar-title.component.scss']
})
export class ToolbarTitleComponent {
  @Input() title: string = '';
  iconFa = '';
  iconMat = '';
  fontSet = '';

  @Input()
  set icon(value: string) {
    if (value.includes('fa-')) {
      this.fontSet = 'fa';
      this.iconFa = `icon-space-mat ${value}`;
      return;
    }
    
    this.iconMat = value;

  };

}
