# 📘 DataSaarthi

DataSaarthi is a simple project I built to explore how AI can be used to interact with documents using natural language.

Instead of manually reading long PDFs, you can upload a document and ask questions — the system processes the content and gives you relevant answers.

---
## 📸 Screenshot

![App Screenshot](https://github.com/user-attachments/assets/93267239-ffa8-4774-8de0-cdd835376db1)

---

## 💡 Features

- Upload PDF documents  
- Automatically split content into chunks  
- Generate embeddings for semantic search  
- Ask questions in natural language  
- Get answers based on document content  

---

## 🧠 How It Works

This project follows a basic **Retrieval-Augmented Generation (RAG)** approach.

### Document Processing
1. Upload a PDF  
2. Extract and split the content into smaller chunks  
3. Convert each chunk into vector embeddings  
4. Store embeddings in the database  

### Question Answering
1. User asks a question  
2. System retrieves relevant chunks using similarity search  
3. Sends those chunks along with the question to the LLM  
4. Model generates the final answer  

---

## 🛠 Tech Stack

- **Backend:** Spring Boot (Java)  
- **Frontend:** Angular  
- **LLM:** Ollama (TinyLlama)  
- **Database:** PostgreSQL (with vector support)  
- **Search:** Embedding-based similarity search  

---


## 🚀 How to Run

### 1. Clone and Build the Project

Clone the repository and build the Docker images:

```bash
docker-compose build
```
<img width="1916" height="1006" alt="Screenshot from 2026-03-18 16-12-52" src="https://github.com/user-attachments/assets/afceeac0-3d7f-4881-a3b9-a9f3bb5d4984" />


---

### 2. Start the Containers

Run the containers:

```bash
docker-compose up
```
<img width="1916" height="1050" alt="Screenshot from 2026-03-18 16-16-21" src="https://github.com/user-attachments/assets/605b3348-bb38-44ed-97da-320f9d0e7c95" />

---

### 3. Setup Database

- Open **Adminer** (PostgreSQL UI running in Docker)  
- Log in using your database credentials  
- Go to SQL console  
- Execute scripts from the `./scripts` folder  

---

### 4. Upload Document

- Upload your PDF (example: Indian Constitution)  
- The system will process and generate embeddings  
- You can verify data in the `document_chunks` table  

**Note:** Processing time depends on your CPU. Please wait until it completes.

---

### 5. Ask Questions

Once processing is complete, you can start asking questions through the UI.

---

## 📝 Notes

- This is a learning project to understand RAG systems  
- Performance depends on system resources and model size  
- TinyLlama is used for lightweight local inference  

---

## 🚧 Future Improvements

- Streaming responses (ChatGPT-like UI)  
- Better ranking of retrieved chunks  
- Support for multiple documents  
- Improved UI/UX  
- Caching for faster responses  

---
