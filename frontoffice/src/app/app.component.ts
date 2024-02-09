import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { AnnouncementListComponent } from "./components/announcement-list/announcement-list.component";
import { VoitureFormComponent } from "./components/voiture-form/voiture-form.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss',
    imports: [RouterOutlet, RouterLink, RouterLinkActive, AnnouncementListComponent, VoitureFormComponent]
})
export class AppComponent {
  title = 'frontoffice';
}
