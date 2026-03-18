📘 DataSaarthi

A small project I built to explore how we can ask questions on documents using AI.

The idea is simple — instead of manually reading PDFs, you upload them and just ask questions. The system reads, understands, and gives you answers.

💡 What it does

Upload a PDF

Break it into chunks and process it

Convert content into embeddings

Let you ask questions

Return answers based on the document

🧠 How it works (high level)

It follows a basic RAG (Retrieval-Augmented Generation) flow:

Document is uploaded

Content is split into smaller chunks

Each chunk is converted into embeddings

When a question is asked:

Relevant chunks are fetched

Sent along with the question to the model

Model generates the final answer

🛠 Tech stack

Backend: Spring Boot (Java)

Frontend: Angular

LLM: Ollama (TinyLlama)

Search: Embedding-based similarity

<img width="1916" height="1006" alt="Screenshot from 2026-03-18 16-02-24" src="https://github.com/user-attachments/assets/e1e8b37a-d337-4156-8358-1c41d4553266" />
