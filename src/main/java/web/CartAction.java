package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Cart;
import domain.CartItem;
import domain.Item;
import service.CatalogService;

import java.util.Iterator;
import java.util.Map;

public class CartAction extends ActionSupport {
    private Cart cart = new Cart();
    private String workingItemId;
    private CatalogService catalogService;
    private String itemId;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setWorkingItemId(String workingItemId) {
        this.workingItemId = workingItemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public CartAction() {
        catalogService = new CatalogService();
    }

    public String ViewCart() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Cart cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
            session.put("cart", cart);
        }
        return "success";
    }

    public String AddItemToCart() {
        Map session = WebUtils.getSession();
        Cart cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            // isInStock is a "real-time" property that must be updated
            // every time an item is added to the cart, even if other
            // item details are cached.
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
        }
        session.put("cart", cart);
        return "success";
    }

    public String removeItemFromCart() {
        Map session = WebUtils.getSession();
        Cart cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        Item item = cart.removeItemById(workingItemId);
        session.put("cart", cart);
        if (item == null) {
            WebUtils.setMessage("Attempted to remove null CartItem from Cart.");
            return "error";
        } else {
            return "success";
        }
    }

    public String updateCartQuantities() {
        Map session = WebUtils.getSession();
        Cart cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
        }
//        Iterator<CartItem> cartItems = getCart().getAllCartItems();
        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt(itemId);
                getCart().setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
        }
        session.put("cart", cart);
        return "success";
    }

    public String checkOut() {
        return "success";
    }

    public void clear() {
        cart = new Cart();
        workingItemId = null;
    }

    public String getWorkingItemId() {
        return workingItemId;
    }

    public String getItemId() {
        return itemId;
    }
}
