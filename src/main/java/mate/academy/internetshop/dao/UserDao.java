package mate.academy.internetshop.dao;

import java.sql.ResultSet;
import java.util.Optional;
import mate.academy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {
    Optional<User> findByLogin(String login);

    User getUserFromResultSet(ResultSet rs);

    void setRoleToDb(User user);
}
