package org.csu.my_pet_store_spring.persistence;

import org.csu.my_pet_store_spring.domain.Product;

import java.util.List;

public interface ProductMapper {

  List<Product> getProductListByCategory(String categoryId);

  Product getProduct(String productId);

  List<Product> searchProductList(String keywords);

}
