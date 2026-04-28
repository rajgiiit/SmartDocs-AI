package com.dailycodebuffer.service;


import com.dailycodebuffer.service.stratgey.DocumentReaderStrategy;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentIngestionService {

    private final SimpleVectorStore vectorStore;
    private final DocumentReaderStrategy pdfReaderStrategy;

    public DocumentIngestionService(SimpleVectorStore vectorStore, DocumentReaderStrategy pdfReaderStrategy) {
        this.vectorStore = vectorStore;
        this.pdfReaderStrategy = pdfReaderStrategy;
    }

    public void processFile(MultipartFile file) throws IOException {
        InputStreamResource resource = new InputStreamResource(file.getInputStream());


        List<Document> documents = pdfReaderStrategy.read(resource);


        TokenTextSplitter textSplitter = new TokenTextSplitter();
        List<Document> splitDocuments = textSplitter.apply(documents);


        vectorStore.add(splitDocuments);
    }
}
