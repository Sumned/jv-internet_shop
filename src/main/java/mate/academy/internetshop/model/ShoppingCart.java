package mate.academy.internetshop.model;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private Long userId;
    private Long id;

    public ShoppingCart(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "products="
                + products + ", user="
                + userId + ", id="
                + id + '}';
    }
}
