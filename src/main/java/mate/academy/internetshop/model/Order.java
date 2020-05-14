package mate.academy.internetshop.model;

import java.util.List;
import mate.academy.internetshop.db.Storage;

public class Order {
    private Long id;
    private Long userId;
    private List<Product> products;

    public Order(List<Product> products, Long userId) {
        this.id = Storage.orderId;
        this.products = products;
        this.userId = userId;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id
                + ", user=" + userId
                + ", products="
                + products + '}';
    }
}
