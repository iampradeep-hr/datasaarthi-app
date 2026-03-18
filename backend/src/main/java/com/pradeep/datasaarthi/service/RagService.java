package com.pradeep.datasaarthi.service;

import com.pradeep.datasaarthi.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RagService {

    private final PdfService pdfService;
    private final OllamaClient ollamaClient;
    private final DocumentRepository repository;

    public RagService(PdfService pdfService, OllamaClient ollamaClient, DocumentRepository repository) {
        this.pdfService = pdfService;
        this.ollamaClient = ollamaClient;
        this.repository = repository;
    }

    private AtomicInteger processed = new AtomicInteger(0);
    private int total = 0;

    public void processPdf(MultipartFile file) throws IOException {
        String text = pdfService.extractText(file);
        List<String> chunks = pdfService.splitText(text);

        total = chunks.size();
        processed.set(0);

        chunks.parallelStream().forEach(chunk -> {
            String embedding = ollamaClient.getEmbedding(chunk);
            repository.save(chunk, embedding);
            processed.incrementAndGet();
        });
    }

    public String ask(String question) {

        String queryEmbedding = ollamaClient.getEmbedding(question);

        List<String> contextChunks = repository.findSimilar(queryEmbedding);

        String context = String.join("\n", contextChunks);

        String prompt = """
            Answer based on the context below:

            %s

            Question: %s
            """.formatted(context, question);

        Map<String, Object> result = ollamaClient.generate(prompt);

        return result.get("response").toString();
    }
}
