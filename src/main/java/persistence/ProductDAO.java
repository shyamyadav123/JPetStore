package persistence;

import domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface ProductDAO {
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(@Param("keywords") String keywords);

}
