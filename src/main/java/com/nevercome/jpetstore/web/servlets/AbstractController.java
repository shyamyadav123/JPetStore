package com.nevercome.jpetstore.web.servlets;

import java.io.Serializable;

public class AbstractController implements Serializable {
    private static final long serialVersionUID = -1767714708233127983L;

    protected static final String ERROR = "/WEB-INF/views/modules/common/Error.jsp";

    private static final String MAIN = "/WEB-INF/views/modules/catalog/Main.jsp";
    private static final String VIEW_CATEGORY = "/WEB-INF/views/modules/catalog/Category.jsp";
    private static final String VIEW_PRODUCT = "/WEB-INF/views/modules/catalog/Product.jsp";
    private static final String VIEW_ITEM = "/WEB-INF/views/modules/catalog/Item.jsp";
    private static final String SEARCH_PRODUCTS = "/WEB-INF/views/modules/catalog/SearchProducts.jsp";

}
