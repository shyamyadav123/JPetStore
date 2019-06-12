package org.csu.my_pet_store_spring.service;

import org.csu.my_pet_store_spring.domain.Category;
import org.csu.my_pet_store_spring.domain.Product;
import org.csu.my_pet_store_spring.domain.Item;
import org.csu.my_pet_store_spring.persistence.CategoryMapper;
import org.csu.my_pet_store_spring.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CatalogService {

    public List<Category> getCategoryList();

    public Category getCategory(String categoryId);

    public Product getProduct(String productId);

    public List<Product> getProductListByCategory(String categoryId);

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) ;

    public List<Item> getItemListByProduct(String productId);

    public Item getItem(String itemId) ;

    public boolean isItemInStock(String itemId);
}
