
package info.kowalczuk.spring.impl.data;

import info.kowalczuk.spring.api.data.TypeRepository;
import info.kowalczuk.spring.api.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository("typeRepository")
public class TypeRepositoryImpl implements TypeRepository {
    @Autowired
    private Map<String, Type> types;

    public Type findById(String id) {
        Type type = types.get(id);
        return type;
    }

    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }
}