package com.nevercome.jpetstore.service.impl;

import com.nevercome.jpetstore.domain.model.Category;
import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.CategoryDAO;
import com.nevercome.jpetstore.persistence.dao.ItemDAO;
import com.nevercome.jpetstore.persistence.dao.ProductDAO;
import com.nevercome.jpetstore.persistence.dao.impl.CategoryDAOImpl;
import com.nevercome.jpetstore.persistence.dao.impl.ItemDAOImpl;
import com.nevercome.jpetstore.persistence.dao.impl.ProductDAOImpl;
import com.nevercome.jpetstore.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private static class SingletonHolder {
        private static final CatalogService INSTANCE = new CatalogServiceImpl();
    }

    private CatalogServiceImpl() {
    }

    public static final CatalogService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private CategoryDAO categoryDAO = CategoryDAOImpl.getInstance();
    private ItemDAO itemDAO = ItemDAOImpl.getInstance();
    private ProductDAO productDAO = ProductDAOImpl.getInstance();

    @Override
    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    @Override
    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    @Override
    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    @Override
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    @Override
    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    @Override
    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
