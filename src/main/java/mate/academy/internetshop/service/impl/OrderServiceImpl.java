package mate.academy.internetshop.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(List<Product> products, User user) throws SQLException {
        List<Product> productsCopy = new ArrayList<>(products);
        shoppingCartService.clear(shoppingCartService.getByUserId(user.getId()));
        return orderDao.create(new Order(user, productsCopy));
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderDao.getUserOrders(userId);
    }

    @Override
    public Order create(Order order) throws SQLException {
        return orderDao.create(order);
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id).get();
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.delete(id);
    }
}
