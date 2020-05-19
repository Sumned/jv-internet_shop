package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.exceptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public Optional<User> findByLogin(String login) {
        String query = "SELECT * FROM users "
                + "JOIN users_roles ON users.user_id = users_roles.user_id "
                + "JOIN roles ON users_roles.role_id = roles.role_id "
                + "WHERE users.login=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to find user with login " + login, e);
        }
    }

    @Override
    public User create(User element) {
        String query = "INSERT INTO users (name, login, password, salt) VALUES (?, ?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getName());
            statement.setString(2, element.getLogin());
            statement.setString(3, element.getPassword());
            statement.setBytes(4, element.getSalt());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            element.setId(resultSet.getLong(1));
            setRoleToDb(element);
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to create user " + element.getName(), e);
        }
    }

    @Override
    public Optional<User> get(Long id) {
        String query = "SELECT * FROM users "
                + "JOIN users_roles ON users.user_id = users_roles.user_id "
                + "JOIN roles ON users_roles.role_id = roles.role_id "
                + "WHERE users.user_id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to find user with id " + id, e);
        }
    }

    @Override
    public List<User> getAll() {
        String allUserQuery = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(allUserQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(get(resultSet.getLong("user_id")).get());
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Somethings gone wrong", e);
        }
        return users;
    }

    @Override
    public User update(User element) {
        String query = "UPDATE users SET name = ?,"
                + " login = ?, password = ? WHERE user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, element.getName());
            statement.setString(2, element.getLogin());
            statement.setString(3, element.getLogin());
            statement.setLong(4, element.getId());
            statement.executeUpdate();
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Delete failed", e);
        }
    }

    @Override
    public User getUserFromResultSet(ResultSet rs) {
        User user = null;
        try {
            user = new User(rs.getString("login"),
                    rs.getString("password"));
            user.setId(rs.getLong("user_id"));
            user.setSalt(rs.getBytes("salt"));
            user.addRoles(Role.of(rs.getString("role_name")));
            while (rs.next()) {
                user.addRoles(Role.of(rs.getString("role_name")));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get user", e);
        }
        return user;
    }

    @Override
    public void setRoleToDb(User user) {
        String queryGetRoleId = "SELECT role_id FROM roles WHERE role_name = ?";
        String querySetRole = "INSERT INTO users_roles (role_id, user_id) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement selectStatement =
                    connection.prepareStatement(queryGetRoleId);
            PreparedStatement setStatement =
                    connection.prepareStatement(querySetRole);
            for (Role role : user.getRoles()) {
                selectStatement.setString(1, role.getRoleName().name());
                ResultSet resultSet = selectStatement.executeQuery();
                resultSet.next();
                setStatement.setLong(1, resultSet.getLong("role_id"));
                setStatement.setLong(2, user.getId());
                setStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to set Role", e);
        }
    }
}
