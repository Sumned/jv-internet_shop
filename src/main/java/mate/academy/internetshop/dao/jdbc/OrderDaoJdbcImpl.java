package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.exceptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class OrderDaoJdbcImpl implements OrderDao {
    @Override
    public List<Order> getUserOrders(Long userId) {
        String query = "SELECT * FROM orders WHERE user_id = ?;";
        List<Order> ordersUserAll = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement allStatement = connection.prepareStatement(query);
            allStatement.setLong(1, userId);
            ResultSet resultSet = allStatement.executeQuery();
            while (resultSet.next()) {
                ordersUserAll.add(get(resultSet.getLong("order_id")).get());
            }

        } catch (SQLException e) {
            throw new DataProcessingException("Somethings gone wrong", e);
        }
        return ordersUserAll;
    }

    @Override
    public Order create(Order element) {
        String query = "INSERT INTO orders (user_id) VALUES (?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement orderStatement =
                    connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            orderStatement.setLong(1, element.getUserId());
            orderStatement.executeUpdate();
            ResultSet resultSet = orderStatement.getGeneratedKeys();
            resultSet.next();
            element.setId(resultSet.getLong(1));
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to create order to this user ", e);
        }
    }

    @Override
    public Optional<Order> get(Long id) {
        String query = "SELECT * FROM orders "
                + "LEFT JOIN order_products ON orders.order_id = order_products.order_id "
                + "LEFT JOIN products ON products.product_id = order_products.product_id "
                + "WHERE orders.order_id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getOrderFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to find order with id " + id, e);
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM orders;";
        List<Order> ordersAll = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement allStatement = connection.prepareStatement(query);
            ResultSet resultSet = allStatement.executeQuery();
            while (resultSet.next()) {
                ordersAll.add(get(resultSet.getLong("order_id")).get());
            }

        } catch (SQLException e) {
            throw new DataProcessingException("Somethings gone wrong", e);
        }
        return ordersAll;
    }

    @Override
    public Order update(Order element) {
        clear(element.getId());
        String query = "INSERT INTO order_products(order_id, product_id) VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            for (Product product : element.getProducts()) {
                statement.setLong(1, element.getId());
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM orders WHERE order_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public boolean clear(Long id) {
        String query = "DELETE FROM order_products WHERE order_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public Order getOrderFromResultSet(ResultSet rs) {
        Order order = null;
        try {
            List<Product> list = new ArrayList<>();
            order = new Order(list, rs.getLong("user_id"));
            order.setId(rs.getLong("order_id"));
            if (rs.getString("name") != null) {
                Product product = new Product(rs.getString("name"), rs.getBigDecimal("price"));
                product.setId(rs.getLong("product_id"));
                list.add(product);
                while (rs.next()) {
                    product = new Product(rs.getString("name"), rs.getBigDecimal("price"));
                    product.setId(rs.getLong("product_id"));
                    list.add(product);
                }
                order.setProducts(list);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get order ", e);
        }
        return order;
    }
}
