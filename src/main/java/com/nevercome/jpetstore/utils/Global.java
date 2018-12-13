package com.nevercome.jpetstore.utils;

public class Global {
    public static final String ACCOUNT_DAO = "account_dao";
    public static final String CATEGORY_DAO = "category_dao";
    public static final String ITEM_DAO = "item_dao";
    public static final String LINEITEM_DAO = "lineItem_dao";
    public static final String ORDER_DAO = "order_dao";
    public static final String PRODUCT_DAO = "product_dao";
    public static final String SEQUENCE_DAO = "sequence_dao";

    public static final String ACCOUNT_SERVICE = "account_service";
    public static final String CATALOG_SERVICE = "catalog_service";
    public static final String ORDER_SERVICE = "order_service";

    //    如果这样的话应该写在资源文件里 每次启动的时候加载 这里写直接写 之后再改
    public static final String ACCOUNT_USER_ID = "";

    public static final String COL_CATEGORY_ID = "catid";
    public static final String COL_CATEGORY_NAME = "name";
    public static final String COL_CATEGORY_DESCN = "descn";

    public static final String COL_PRODUCT_ID = "productid";
    public static final String COL_PRODUCT_CATEGORY = "category";
    public static final String COL_PRODUCT_NAME = "name";
    public static final String COL_PRODUCT_DESCN = "descn";

    public static final String COL_ITEM_ID = "itemid";
    public static final String COL_ITEM_PRODUCTID = "productid";
    public static final String COL_ITEM_LISTPRICE = "listprice";
    public static final String COL_ITEM_UNITCOST = "unitcost";
    public static final String COL_ITEM_SUPPLIER = "supplier";
    public static final String COL_ITEM_STATUS = "status";
    public static final String COL_ITEM_ATTR1 = "attr1";
    public static final String COL_ITEM_ATTR2 = "attr2";
    public static final String COL_ITEM_ATTR3 = "attr3";
    public static final String COL_ITEM_ATTR4 = "attr4";
    public static final String COL_ITEM_ATTR5 = "attr5";
    public static final String COL_ITEM_QTY = "qty";

    public static final String COL_ACCOUNT_ID = "userid";
    public static final String COL_ACCOUNT_EMAIL = "email";
    public static final String COL_ACCOUNT_FIRSTNAME = "firstname";
    public static final String COL_ACCOUNT_LASTNAME = "lastname";
    public static final String COL_ACCOUNT_STATUS = "status";
    public static final String COL_ACCOUNT_ADDR1 = "addr1";
    public static final String COL_ACCOUNT_ADDR2 = "addr2";
    public static final String COL_ACCOUNT_CITY = "city";
    public static final String COL_ACCOUNT_STATE = "state";
    public static final String COL_ACCOUNT_ZIP = "zip";
    public static final String COL_ACCOUNT_COUNTRY = "country";
    public static final String COL_ACCOUNT_PHONE = "phone";

    public static final String COL_PROFILE_ID = "userid";
    public static final String COL_PROFILE_LANGPREF = "langpref";
    public static final String COL_PROFILE_MYLISTOPT = "mylistopt";
    public static final String COL_PROFILE_banneropt = "banneropt";
    public static final String COL_PROFILE_FAVCATEGORY = "favcategory";


    public static final String COL_BANNERDATA_FAVCATEGORY = "favcategory";
    public static final String COL_BANNERDATA_BANNERNAME = "bannername";

    public static final String COL_SIGNON_USERNAME = "username";
    public static final String COL_SIGNON_PASSWORD = "password";

    public static final String COL_SEQUENCE_NAME = "name";
    public static final String COL_SEQUENCE_NEXITID = "nextid";

    public static final String COL_LINEITEM_ORDERID = "orderid";
    public static final String COL_LINEITEM_LINENUM = "linenum";
    public static final String COL_LINEITEM_ITEMID = "itemid";
    public static final String COL_LINEITEM_QUANTITY = "quantity";
    public static final String COL_LINEITEM_UNITPRICE = "unitprice";

    public static final String COL_ORDER_USERNAME = "userid";
    public static final String COL_ORDER_EXPIREDATE = "exprdate";
    public static final String COL_ORDER_CREDITCARD = "creditcard";
    public static final String COL_ORDER_COURIER = "courier";
    public static final String COL_ORDER_BILLZIP = "billzip";
    public static final String COL_ORDER_BILLTOLASTNAME = "billtolastname";
    public static final String COL_ORDER_BILLTOFIRSTNAME = "billtofirstname";
    public static final String COL_ORDER_BILLSTATE = "billstate";
    public static final String COL_ORDER_BILLCOUNTRY = "billcountry";
    public static final String COL_ORDER_BILLCITY = "billcity";
    public static final String COL_ORDER_BILLADDR2 = "billaddr2";
    public static final String COL_ORDER_BILLADDR1 = "billaddr1";
    public static final String COL_ORDER_CARDTYPE = "cardtype";
    public static final String COL_ORDER_LOCALE = "locale";
    public static final String COL_ORDER_ORDERDATE = "orderdate";
    public static final String COL_ORDER_ORDERID = "orderid";
    public static final String COL_ORDER_SHIPADDR1 = "shipaddr1";
    public static final String COL_ORDER_SHIPADDR2 = "shipaddr2";
    public static final String COL_ORDER_SHIPCITY = "shipcity";
    public static final String COL_ORDER_SHIPCOUNTRY = "shipcountry";
    public static final String COL_ORDER_SHIPSTATE = "shipstate";
    public static final String COL_ORDER_SHIPTOFIRSTNAME = "shiptofirstname";
    public static final String COL_ORDER_SHIPTOLASTNAME = "shiptolastname";
    public static final String COL_ORDER_SHIPZIP = "shipzip";
    public static final String COL_ORDER_STATUS = "status";
    public static final String COL_ORDER_TOTALPRICE = "totalprice";

    public static final String COL_ORDERSTATUS_ORDERID = "orderid";
    public static final String COL_ORDERSTATUS_LINENUM = "linenum";
    public static final String COL_ORDERSTATUS_TIMESTAMP = "timestamp";
    public static final String COL_ORDERSTATUS_STATUS = "status";
}
