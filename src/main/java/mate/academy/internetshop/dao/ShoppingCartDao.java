package mate.academy.internetshop.dao;

import java.util.List;
import mate.academy.internetshop.model.ShoppingCart;

public interface ShoppingCartDao extends GenericDao<ShoppingCart, Long> {

    List<ShoppingCart> getAll();

}
