package mate.academy.internetshop.db;

import java.util.ArrayList;
import java.util.List;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.model.User;

public class Storage {
    public static Long productId = 0L;
    public static Long shoppingCartId = 0L;
    public static Long userId = 0L;
    public static Long orderId = 0L;
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    public static void addProduct(Product product) {
        productId++;
        products.add(product);
    }

    public static void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartId++;
        shoppingCarts.add(shoppingCart);
    }

    public static void addUser(User user) {
        userId++;
        users.add(user);
    }

    public static void addOrder(Order order) {
        orderId++;
        orders.add(order);
    }

}
