package mate.academy.internetshop.dao;

import java.sql.ResultSet;
import java.util.List;
import mate.academy.internetshop.model.ShoppingCart;

public interface ShoppingCartDao extends GenericDao<ShoppingCart, Long> {
    List<ShoppingCart> getAll();

    boolean deleteProduct(Long productId, Long cardId);

    ShoppingCart getShoppingCartFromResultSet(ResultSet rs);

}
