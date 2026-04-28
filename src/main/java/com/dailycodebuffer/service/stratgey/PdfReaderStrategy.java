package com.dailycodebuffer.service.stratgey;

import org.springframework.ai.document.Document;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;

import java.util.List;

@Component
public class PdfReaderStrategy implements DocumentReaderStrategy {
    @Override
    public List<Document> read(Resource resource) {
        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(resource);
        return pdfReader.get();
    }
}
