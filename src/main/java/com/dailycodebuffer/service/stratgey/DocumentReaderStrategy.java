package com.dailycodebuffer.service.stratgey;

import org.springframework.ai.document.Document;
import org.springframework.core.io.Resource;
import java.util.List;

public interface DocumentReaderStrategy {
    List<Document> read(Resource resource);
}
