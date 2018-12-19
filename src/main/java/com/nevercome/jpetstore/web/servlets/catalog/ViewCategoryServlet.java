package com.nevercome.jpetstore.web.servlets.catalog;

import com.nevercome.jpetstore.domain.model.Category;
import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.impl.AccountDAOImpl;
import com.nevercome.jpetstore.service.CatalogService;
import com.nevercome.jpetstore.service.impl.CatalogServiceImpl;
import com.nevercome.jpetstore.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog/viewCategory")
public class ViewCategoryServlet extends HttpServlet {

    private static final String VIEW_CATEGORY = "/WEB-INF/views/modules/catalog/Category.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private String categoryId;
    private Category category;

    private List<Product> productList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        categoryId = request.getParameter("categoryId");
        if(StringUtils.isNoneBlank(categoryId)) {
            productList = catalogService.getProductListByCategory(categoryId);
            category = catalogService.getCategory(categoryId);
        }
        request.setAttribute("productList", productList);
        request.setAttribute("category", category);
        request.getRequestDispatcher(VIEW_CATEGORY).forward(request, response);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
