package com.nevercome.jpetstore.web.servlets.catalog;

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

@WebServlet("/catalog/viewProduct")
public class ViewProductServlet extends HttpServlet {

    private static final String VIEW_PRODUCT = "/WEB-INF/views/modules/catalog/Product.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private String productId;
    private Product product;

    private List<Item> itemList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productId = request.getParameter("productId");
        if (StringUtils.isNoneBlank(productId)) {
            itemList = catalogService.getItemListByProduct(productId);
            product = catalogService.getProduct(productId);
        }
        request.setAttribute("product", product);
        request.setAttribute("itemList", itemList);
        request.getRequestDispatcher(VIEW_PRODUCT).forward(request, response);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
