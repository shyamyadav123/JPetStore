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

@WebServlet("/catalog/viewItem")
public class ViewItemServlet extends HttpServlet {

    private static final String VIEW_ITEM = "/WEB-INF/views/modules/catalog/Item.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private Product product;

    private String itemId;
    private Item item;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        itemId = request.getParameter("itemId");
        if(StringUtils.isNoneBlank(itemId)) {
            item = catalogService.getItem(itemId);
            product = item.getProduct();
        }
        request.setAttribute("item", item);
        request.setAttribute("product", product);
        request.getRequestDispatcher(VIEW_ITEM).forward(request, response);
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

}
