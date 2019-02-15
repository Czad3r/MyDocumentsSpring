package info.kowalczuk.spring.api.data;

import info.kowalczuk.spring.api.model.Type;

public interface TypeRepository {
    public Type[] getAll();

    public Type findById(String id);
}
