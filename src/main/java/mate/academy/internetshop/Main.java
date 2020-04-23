package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

public class Main {

    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        for (int i = 0; i < 10; i++) {
            productService.create(new Product("Item" + i, new BigDecimal(i)));
        }
        System.out.println("All list:");
        for (Product i : productService.getAll()) {
            System.out.println(i);
        }
        Product item1 = productService.get(1L);
        System.out.println(item1 + " - item1 before update");
        item1.setPrice(new BigDecimal("10"));
        System.out.println(productService.update(item1) + " - item1 after update");
        productService.delete(2L);
        System.out.println("delete item2: ");
        for (Product i : productService.getAll()) {
            System.out.println(i);
        }
    }
}
