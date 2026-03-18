package com.pradeep.datasaarthi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OllamaClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String OLLAMA_URL = "http://ollama:11434/api";

    public String getEmbedding(String text) {
        Map<String, Object> request = Map.of(
                "model", "nomic-embed-text",
                "prompt", text
        );

        Map response = restTemplate.postForObject(
                OLLAMA_URL + "/embeddings",
                request,
                Map.class
        );

        List<Double> embedding = (List<Double>) response.get("embedding");

        return embedding.toString(); // "[0.1, 0.2, ...]"
    }

    public Map<String, Object> generate(String prompt) {

        Map<String, Object> request = Map.of(
                "model", "tinyllama",
                "prompt", prompt,
                "stream", false
        );

        Map response = restTemplate.postForObject(
                OLLAMA_URL + "/generate",
                request,
                Map.class
        );

        System.out.println("OLLAMA RAW RESPONSE: " + response);

        if (response == null) {
            return Map.of("response", "Error: No response from Ollama", "done", true);
        }

        Object res = response.get("response");

        if (res == null) {
            return Map.of("response", "Error: Empty response from model", "done", true);
        }

        return Map.of(
                "response", res.toString(),
                "done", true
        );
    }
}
