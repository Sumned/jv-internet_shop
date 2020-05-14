package mate.academy.internetshop.model;

import java.math.BigDecimal;
import mate.academy.internetshop.db.Storage;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.id = Storage.productId;
        this.name = name;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='"
                + name + '\''
                + ", price="
                + price + '}';
    }
}
