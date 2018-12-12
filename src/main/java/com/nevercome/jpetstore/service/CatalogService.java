package com.nevercome.jpetstore.service;

import com.nevercome.jpetstore.domain.model.Category;
import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;

import java.util.List;

public interface CatalogService {
    List<Category> getCategoryList();

    Category getCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> getProductListByCategory(String categoryId);

    List<Product> searchProductList(String keyword);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);

    boolean isItemInStock(String itemId);
}
