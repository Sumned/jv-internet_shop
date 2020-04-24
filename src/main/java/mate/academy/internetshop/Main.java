package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class Main {

    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        UserService userService = (UserService) injector.getInstance(UserService.class);
        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        ShoppingCartService shoppingCartService = (ShoppingCartService)
                injector.getInstance(ShoppingCartService.class);
        for (int i = 0; i < 10; i++) {
            productService.create(new Product("Item" + i, new BigDecimal(i)));
            userService.create(new User("User" + i, "user" + i + "@mail.com"));
        }
        System.out.println("All products list:");
        for (Product i : productService.getAll()) {
            System.out.println(i);
        }
        System.out.println("All users list:");
        for (User i : userService.getAll()) {
            System.out.println(i);
        }
        Product item1 = productService.get(1L);
        User user1 = userService.get(1L);
        System.out.println(item1 + " - item1 before update");
        System.out.println(user1 + " - user before update");
        item1.setPrice(new BigDecimal("10"));
        user1.setName("user10");
        System.out.println(productService.update(item1) + " - item1 after update");
        System.out.println(userService.update(user1) + " - user1 after update");
        productService.delete(2L);
        userService.delete(2L);
        System.out.println("delete item2: ");
        for (Product i : productService.getAll()) {
            System.out.println(i);
        }
        System.out.println("delete user2: ");
        for (User i : userService.getAll()) {
            System.out.println(i);
        }
    }
}
