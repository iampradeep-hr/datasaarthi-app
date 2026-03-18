package com.pradeep.datasaarthi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DocumentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String content, String embedding) {
        String sql = "INSERT INTO document_chunks (content, embedding) VALUES (?, ?::vector)";
        jdbcTemplate.update(sql, content, embedding);
    }

    public List<String> findSimilar(String embedding) {
        String sql = """
            SELECT content FROM document_chunks
            ORDER BY embedding <-> ?::vector
            LIMIT 3
        """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getString("content"),
                embedding
        );
    }
}
