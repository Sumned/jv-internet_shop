package mate.academy.internetshop.dao;

import java.sql.ResultSet;
import mate.academy.internetshop.model.Product;

public interface ProductDao extends GenericDao<Product, Long> {

    Product getProductFromResultSet(ResultSet resultSet);

}
