package mate.academy.internetshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.db.Storage;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class AddToShoppingCartController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private final ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productId = req.getParameter("id");
        Long id = Long.valueOf(productId);
        if (Storage.shoppingCartId == 0) {
            shoppingCartService
                    .addProduct(new ShoppingCart(new ArrayList<>(),
                            userService.get(USER_ID)), productService.get(id));
        } else {
            shoppingCartService
                    .addProduct(shoppingCartService.getByUserId(USER_ID),
                            productService.get(id));
        }
        resp.sendRedirect(req.getContextPath() + "/products/all");
    }
}
