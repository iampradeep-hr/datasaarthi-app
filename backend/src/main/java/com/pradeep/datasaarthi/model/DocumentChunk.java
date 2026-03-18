package com.pradeep.datasaarthi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentChunk {
    private Long id;
    private String content;
    private String embedding; // stores as "[0.1, 0.2, ...]"
}
