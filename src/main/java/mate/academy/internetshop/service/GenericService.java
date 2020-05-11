package mate.academy.internetshop.service;

import java.sql.SQLException;
import java.util.List;

public interface GenericService<T, V> {

    T create(T element) throws SQLException;

    T get(V id);

    List<T> getAll();

    T update(T element);

    boolean delete(V id);
}
