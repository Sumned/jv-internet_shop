package mate.academy.internetshop.model;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private User user;
    private Long id;

    public ShoppingCart(List<Product> products, User user, Long id) {
        this.products = products;
        this.user = user;
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
