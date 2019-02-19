package info.kowalczuk.spring.impl.data;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.impl.data.jdbc.DocumentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("documentRepository")
public class DocumentRepositoryImpl implements DocumentRepository {

    private static final String queryAll = "select d.documentId, d.name, d.location, d.description as doc_desc, d.typeId, d.created," +
            " d.modified, t.name as type_name, t.description as type_desc, t.extension from documents" +
            " d join types t on d.typeId = t.typeId";
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(queryAll, new DocumentRowMapper());
    }
}
