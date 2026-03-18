import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './chat.html',
  styleUrls: ['./chat.css']
})
export class ChatComponent implements OnInit {

  question = '';
  answer = '';
  status = '';
  error = '';
  loading = false;
  file: File | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    setInterval(() => this.checkStatus(), 3000);
  }

  onFileSelected(event: any) {
    this.file = event.target.files[0];
  }

  upload() {
    if (!this.file) return;

    const formData = new FormData();
    formData.append('file', this.file);

    this.http.post('http://localhost:8080/api/upload', formData)
      .subscribe(() => {
        this.status = 'Processing started...';
      });
  }

  ask() {
    if (!this.question.trim()) return;

    this.loading = true;
    this.answer = '';
    this.error = '';

    this.http.post<any>('http://localhost:8080/api/ask', {
      question: this.question
    }).subscribe({
      next: (res) => {
        console.log("UI RECEIVED:", res);

        this.answer = res.response;
        this.loading = false;
      },
      error: (err) => {
        console.error(err);
        this.error = 'Failed to fetch answer';
        this.loading = false;
      }
    });
  }

  checkStatus() {
    this.http.get<any>('http://localhost:8080/api/status')
      .subscribe(res => {
        this.status = `${res.processed} / ${res.total}`;
      });
  }
}