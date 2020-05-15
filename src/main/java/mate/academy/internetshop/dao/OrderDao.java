package mate.academy.internetshop.dao;

import java.sql.ResultSet;
import java.util.List;
import mate.academy.internetshop.model.Order;

public interface OrderDao extends GenericDao<Order, Long> {
    List<Order> getUserOrders(Long userId);

    boolean clear(Long id);

    Order getOrderFromResultSet(ResultSet rs);
}
