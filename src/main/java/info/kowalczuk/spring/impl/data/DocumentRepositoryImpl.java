package info.kowalczuk.spring.impl.data;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.impl.data.jdbc.DocumentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Repository("documentRepository")
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private String query;
    @Autowired
    private String insert;
    @Autowired
    private String find;
    @Autowired
    private String update;
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(query, new DocumentRowMapper());
    }


    public Document findById(String id) {
        Document updateDocument = null;
        JdbcTemplate template = new JdbcTemplate(dataSource);
        try {
            updateDocument = template.queryForObject(find,
                    new Object[] { id },
                    new DocumentRowMapper());
        } catch (EmptyResultDataAccessException ex) {}
        return updateDocument;
    }
    @Override
    public void save(Document document) {
        try {
            JdbcTemplate template = new JdbcTemplate(dataSource);
            if (null == findById(document.getDocumentId()))
                template.update(
                        insert,
                        document.getDocumentId(),
                        document.getName(), document.getLocation(),
                        document.getDescription(),
                        document.getType().getTypeId(),
                        document.getCreated(), document.getModified());
            else
                template.update(
                        update,
                        document.getName(),
                        document.getLocation(),
                        document.getDescription(),
                        document.getType().getTypeId(), new Date(),
                        document.getDocumentId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
