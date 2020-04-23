package mate.academy.internetshop.model;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private Long orderId;
    private Long id;

    public ShoppingCart(List<Product> products, Long orderId, Long id) {
        this.products = products;
        this.orderId = orderId;
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
