package com.dailycodebuffer.controller;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DocumentController {

    private final org.springframework.ai.vectorstore.VectorStore vectorStore;

    public DocumentController(org.springframework.ai.vectorstore.VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostMapping("/api/documents/upload")
    public String uploadPdf(@RequestParam("file") MultipartFile file) throws Exception {

        ByteArrayResource resource = new ByteArrayResource(file.getBytes());
        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(resource);
        List<Document> wholeDocuments = pdfReader.get();

        TokenTextSplitter textSplitter = new TokenTextSplitter();
        List<Document> chunkedDocuments = textSplitter.apply(wholeDocuments);

        vectorStore.add(chunkedDocuments);

        System.out.println("====== X-RAY UPLOAD ======");
        System.out.println("Successfully extracted and saved " + chunkedDocuments.size() + " chunks to the database!");
        System.out.println("==========================");

        return "Success! Sliced the PDF into " + chunkedDocuments.size() + " readable chunks.";
    }
}