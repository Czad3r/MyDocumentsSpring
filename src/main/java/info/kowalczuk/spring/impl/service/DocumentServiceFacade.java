package info.kowalczuk.spring.impl.service;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("documentFacade")
public class DocumentServiceFacade implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.getAll();
    }

    public Document saveDocument(String id, Document document) {
        return documentRepository.save(id, document);
    }

    public Document removeDocumentById(String id) {
        return documentRepository.removeById(id);
    }

    public Document findDocumentById(String id) {
        return documentRepository.findById(id);
    }

    public boolean updateLocationFromDocumentId(String documentId, String location) {
        Document document = documentRepository.findById(documentId);
        if (null == document)
            return false;
        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }
}
