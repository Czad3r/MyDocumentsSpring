package info.kowalczuk.spring.impl.service;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.model.Type;
import info.kowalczuk.spring.api.service.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("searchEngine")
public class MySearchEngine implements SearchEngine {
    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for (Document document : listAll()) {
            if (document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        return result;
    }

    public List<Document> listAll() {
        return Arrays.asList(documentRepository.getAll());
    }

}
