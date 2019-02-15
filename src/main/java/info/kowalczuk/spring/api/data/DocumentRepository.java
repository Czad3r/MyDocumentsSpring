package info.kowalczuk.spring.api.data;

import info.kowalczuk.spring.api.model.Document;

public interface DocumentRepository {
    public Document[] getAll();
}
