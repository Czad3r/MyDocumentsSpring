package info.kowalczuk.spring.api.service;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.model.Type;

import java.util.List;

public interface SearchEngine {
    public List<Document> findByType(Type documentType);

    public List<Document> listAll();

    public List<Document> findByLocation(String location);

    public Document findById(String id);
}
