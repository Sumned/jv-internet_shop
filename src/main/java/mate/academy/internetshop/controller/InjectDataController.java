package mate.academy.internetshop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private final ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/inject_data.jsp").forward(req, resp);
        for (int i = 0; i < 10; i++) {
            try {
                productService.create(new Product("Item" + i, new BigDecimal(10 + i * 3)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
