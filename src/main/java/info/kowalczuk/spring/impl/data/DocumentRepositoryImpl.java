package info.kowalczuk.spring.impl.data;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("documentRepository")
public class DocumentRepositoryImpl implements DocumentRepository {
    @Autowired
    private List<Document> documents;

    public Document[] getAll() {
        Document[] result = documents.toArray(new Document[documents.size()]);
        return result;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
