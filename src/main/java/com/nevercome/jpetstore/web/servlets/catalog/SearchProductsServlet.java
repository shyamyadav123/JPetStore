package com.nevercome.jpetstore.web.servlets.catalog;

import com.nevercome.jpetstore.domain.model.Category;
import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;
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

@WebServlet("/catalog/searchProducts")
public class SearchProductsServlet extends HttpServlet {

    private static final String ERROR = "/WEB-INF/views/modules/common/Error.jsp";
    private static final String SEARCH_PRODUCTS = "/WEB-INF/views/modules/catalog/SearchProducts.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private String keyword;

    private List<Product> productList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyword = request.getParameter("keyword");
        if (StringUtils.isBlank(keyword)) {
            request.setAttribute("message", "Please enter a keyword to search for, then press the search button.");
            request.setAttribute("productList", null);
            request.getRequestDispatcher(ERROR).forward(request, response);
        } else {
            productList = catalogService.searchProductList(keyword.toLowerCase());
            if(productList != null && productList.size() > 0) {
                request.setAttribute("productList", productList);
                request.getRequestDispatcher(SEARCH_PRODUCTS).forward(request, response);
            } else {
                request.setAttribute("message", "Sorry, the result is null, please check your input.");
                request.setAttribute("productList", null);
                request.getRequestDispatcher(ERROR).forward(request, response);
            }

        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
