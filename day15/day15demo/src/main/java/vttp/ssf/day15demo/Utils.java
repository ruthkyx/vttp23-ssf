package vttp.ssf.day15demo;

import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.day15demo.model.Item;

public class Utils {

    public static final String ATTR_CART = "cart";
    public static final String BEAN_REDIS = "myredis";
    public static final Integer F_NAME = 0;
    public static final Integer F_QUANTITY = 1;

    public static List<Item> getCart(HttpSession sess) {
        List<Item> cart = (List<Item>)sess.getAttribute(ATTR_CART);
        if (null == cart) {
           cart = new LinkedList<>();
           sess.setAttribute(ATTR_CART, cart);
        }
        return cart;
    }
}
