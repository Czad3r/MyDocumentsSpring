package info.kowalczuk.spring.api.data;

import info.kowalczuk.spring.api.model.Document;

import java.util.List;

public interface DocumentRepository {
    public List<Document> getAll();
}
