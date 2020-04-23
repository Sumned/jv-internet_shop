package mate.academy.internetshop.service.impl;

import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.service.ShoppingCart;

@Service
public class ShoppingCartImpl implements ShoppingCart {
    private ShoppingCartDao shoppingCartDao;
    private ProductDao productDao;

    @Override
    public ShoppingCart addItem(Long bucketId, Long itemId) {
        return null;
    }
}
