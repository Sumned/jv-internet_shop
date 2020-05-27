package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.exceptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart element) {
        String query = "INSERT INTO shopping_carts (user_id) VALUES (?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, element.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            element.setId(resultSet.getLong(1));
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to create shopping cart to this user ", e);
        }
    }

    @Override
    public Optional<ShoppingCart> get(Long id) {
        String query = "SELECT * FROM shopping_carts "
                + "LEFT JOIN shopping_carts_products AS s_h_p "
                + "ON shopping_carts.card_id = s_h_p.card_id "
                + "LEFT JOIN products ON products.product_id = s_h_p.product_id "
                + "WHERE shopping_carts.card_id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getShoppingCartFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to find order with id " + id, e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        String query = "SELECT * FROM shopping_carts;";
        List<ShoppingCart> shoppingCartsAll = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement allStatement = connection.prepareStatement(query);
            ResultSet resultSet = allStatement.executeQuery();
            while (resultSet.next()) {
                shoppingCartsAll.add(get(resultSet.getLong("card_id")).orElseThrow());
            }

        } catch (SQLException e) {
            throw new DataProcessingException("Somethings gone wrong", e);
        }
        return shoppingCartsAll;
    }

    @Override
    public ShoppingCart update(ShoppingCart element) {
        delete(element.getId());
        String query = "INSERT INTO shopping_carts_products(card_id, product_id) VALUES(?, ?)";
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
        String query = "DELETE FROM shopping_carts_products WHERE card_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public boolean deleteProduct(Long productId, Long cardId) {
        String query = "DELETE FROM shopping_carts_products "
                + "WHERE product_id = ? AND card_id = ? LIMIT 1;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, productId);
            statement.setLong(2, cardId);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Update failed", e);
        }
    }

    @Override
    public ShoppingCart getShoppingCartFromResultSet(ResultSet rs) {
        ShoppingCart shoppingCart;
        try {
            List<Product> list = new ArrayList<>();
            shoppingCart = new ShoppingCart(list, rs.getLong("user_id"));
            shoppingCart.setId(rs.getLong("card_id"));
            if (rs.getString("name") != null) {
                Product product = new Product(rs.getString("name"), rs.getBigDecimal("price"));
                product.setId(rs.getLong("product_id"));
                list.add(product);
                while (rs.next()) {
                    product = new Product(rs.getString("name"), rs.getBigDecimal("price"));
                    product.setId(rs.getLong("product_id"));
                    list.add(product);
                }
                shoppingCart.setProducts(list);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get shopping cart", e);
        }
        return shoppingCart;
    }
}
