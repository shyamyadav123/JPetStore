package web;

import com.opensymphony.xwork2.ActionSupport;
import domain.Category;
import domain.Item;
import domain.Product;
import service.CatalogService;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public class CatalogAction extends ActionSupport {

    private static final long serialVersionUID = 5849523372175050635L;

    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private static final String VIEW_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";

    private CatalogService catalogService;

    private String keyword;

    private String categoryId;
    private Category category;
    private List<Category> categoryList;

    private String productId;
    private Product product;
    private List<Product> productList;

    private String itemId;
    private Item item;
    private List<Item> itemList;

    public CatalogAction() {
        catalogService = new CatalogService();
    }

    @Override
    public String execute() {
        return null;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }


    public String viewCategory() {
        if (categoryId != null) {
            productList = catalogService.getProductListByCategory(categoryId);
            category = catalogService.getCategory(categoryId);
        }
        return "VIEW_CATEGORY";
    }

    public String viewProduct() {
        if (productId != null) {
            itemList = catalogService.getItemListByProduct(productId);
            product = catalogService.getProduct(productId);
        }
        return "VIEW_PRODUCT";
    }

    public String viewItem() {
        item = catalogService.getItem(itemId);
        product = item.getProduct();
        return "VIEW_ITEM";
    }

    public String searchProducts() {
        if (keyword == null || keyword.length() < 1) {
//            setMessage("Please enter a keyword to search for, then press the search button.");
            return "ERROR";
        } else {
            productList = catalogService.searchProductList(keyword.toLowerCase());
            return "SEARCH_PRODUCTS";
        }
    }

    public void clear() {
        keyword = null;

        categoryId = null;
        category = null;
        categoryList = null;

        productId = null;
        product = null;
        productList = null;

        itemId = null;
        item = null;
        itemList = null;
    }

}
