package mate.academy.internetshop.controller.product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.UserService;

public class GetAllProductController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private static final String USER_ID = "user_id";
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private final ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> allProducts = productService.getAll();
        req.setAttribute("allProducts", allProducts);
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        for (Role role : userService.get(userId).getRoles()) {
            if (role.getRoleName().equals(Role.RoleName.ADMIN)) {
                req.getRequestDispatcher("/WEB-INF/views/products/all_for_admin_only.jsp")
                        .forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/products/all.jsp").forward(req, resp);
            }
        }
    }
}
