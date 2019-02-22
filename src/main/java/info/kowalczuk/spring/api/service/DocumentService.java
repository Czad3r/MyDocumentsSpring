package info.kowalczuk.spring.api.service;

import info.kowalczuk.spring.api.model.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public boolean updateLocationFromDocumentId(String documentId, String location);
}
