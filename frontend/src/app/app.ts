import { Component, signal } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
// Add /chat/ before the filename
import { ChatComponent } from './chat/chat';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HttpClientModule, ChatComponent],
  templateUrl: './app.html',
})
export class App {
  title = signal('datasaarthi-ui');
}
