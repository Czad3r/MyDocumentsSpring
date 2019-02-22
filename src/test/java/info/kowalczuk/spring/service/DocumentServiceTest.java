package info.kowalczuk.spring.service;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.service.DocumentService;
import info.kowalczuk.spring.config.AppConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class DocumentServiceTest {

    @Autowired
    private DocumentService documentFacade;

    private final String DOCUMENT_ID = "431cddbf-f3c0-4076-8c1c-564e7dce16c9";
    private final String DOCUMENT_ID2 = "Alasdka281812-a8sadjamasndas";
    private final String DOCUMENT_ID3 = "cf7fec3e-55bf-426d-8a6f-2ca752ae34ac";
    private final String DOCUMENT_NAME = "Pro Spring Security Book";


    @Test
    public void getDocumentsTest() {
        List<Document> allDocuments = documentFacade.getAllDocuments();
        assertNotNull(allDocuments);
        assertEquals(allDocuments.size(), 4);
    }

    @Test
    public void findAndAddDocumentTest() {
        Document documentById = documentFacade.findDocumentById(DOCUMENT_ID);
        assertNotNull(documentById);
        assertEquals(documentById.getName(), DOCUMENT_NAME);
        documentById.setDocumentId(DOCUMENT_ID2);
        documentFacade.saveDocument(DOCUMENT_ID2, documentById);
        assertEquals(documentFacade.getAllDocuments().size(), 5);
    }

    @Test
    public void updateDocumentTest() {
        Document documentById = documentFacade.findDocumentById(DOCUMENT_ID3);
        int size = documentFacade.getAllDocuments().size();
        documentFacade.saveDocument(DOCUMENT_ID3,documentById);
        assertEquals(documentFacade.getAllDocuments().size(), size);
    }

    @Test
    public void removeDocumentTest() {
        int size = documentFacade.getAllDocuments().size();
        documentFacade.removeDocumentById(DOCUMENT_ID);
        assertEquals(documentFacade.getAllDocuments().size(), size - 1);
    }
}
