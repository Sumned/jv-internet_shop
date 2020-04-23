package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.db.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.ShoppingCart;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart get(Long bucketId) {
        return Storage.shoppingCarts
                .stream()
                .filter(bucket -> bucketId.equals(bucket.getId()))
                .findFirst()
                .orElseThrow(()
                        -> new NoSuchElementException("Can't find item with id " + bucketId));
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return null;
    }
}
