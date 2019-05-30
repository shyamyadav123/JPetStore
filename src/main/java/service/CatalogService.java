package service;

import domain.Category;
import domain.Item;
import domain.Product;
import org.apache.ibatis.session.SqlSession;
import persistence.*;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public class CatalogService {

    private SqlSession session;
    private CategoryDAO categoryDAO;
    private ItemDAO itemDAO;
    private ProductDAO productDAO;

    public CatalogService() {
        this.session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        this.categoryDAO = session.getMapper(CategoryDAO.class);
        this.itemDAO = session.getMapper(ItemDAO.class);
        this.productDAO = session.getMapper(ProductDAO.class);
    }

    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }

}
