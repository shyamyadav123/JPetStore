package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Product;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface ProductMapper {

    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);

}
