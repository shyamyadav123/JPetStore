package com.nevercome.jpetstore.web.servlets.catalog;

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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalog/ajax_search")
public class AjaxSearchServlet extends HttpServlet {

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String keyword = request.getParameter("keyword");
        List<Product> productList = catalogService.searchProductList(keyword);
        List<String> productNames = new ArrayList<>();
        for(Product product : productList) {
            productNames.add(product.getName());
        }

        out.print(productNames);
        out.flush();
        out.close();
    }
}
