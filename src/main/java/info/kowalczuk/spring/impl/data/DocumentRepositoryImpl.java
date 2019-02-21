package info.kowalczuk.spring.impl.data;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.impl.data.jdbc.DocumentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository("documentRepository")
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private DataSource dataSource;

    @Value("#{sql}")
    private Map<String, String> sql;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Document findById(String id) {
        Document document = null;
        JdbcTemplate template = new JdbcTemplate(dataSource);
        try {
            System.out.println(sql.get("find"));
            document = template.queryForObject(sql.get("find"),
                    new Object[]{id},
                    new DocumentRowMapper());
        } catch (EmptyResultDataAccessException ex) {
        }
        return document;
    }

    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(sql.get("query"), new DocumentRowMapper());
    }
}
