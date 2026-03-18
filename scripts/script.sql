-- Enable pgvector
CREATE EXTENSION IF NOT EXISTS vector;

-- Drop old table if exists
DROP TABLE IF EXISTS document_chunks;

-- Create table
CREATE TABLE document_chunks (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    embedding VECTOR(768) NOT NULL
);

-- Create index for fast similarity search
CREATE INDEX idx_document_chunks_embedding
ON document_chunks
USING ivfflat (embedding vector_cosine_ops)
WITH (lists = 100);