package info.kowalczuk.spring.api.data;

import info.kowalczuk.spring.api.model.Document;

import java.util.List;

public interface DocumentRepository {
    List<Document> getAll();

    Document save(String id, Document document);

    Document removeById(String id);

    Document findById(String id);

}
