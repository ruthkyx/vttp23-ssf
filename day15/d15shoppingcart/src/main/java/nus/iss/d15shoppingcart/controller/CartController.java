package nus.iss.d15shoppingcart.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nus.iss.d15shoppingcart.model.Item;
import nus.iss.d15shoppingcart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private Logger logger = Logger.getLogger(CartController.class.getName());
    public static final String ATTR_ITEM = "item";
    public static final String ATTR_CART = "cart";
    public static final String ATTR_USERNAME = "username";

    @Autowired
    private CartService cartSvc;
    
    // to get the info from the posted form 
    @GetMapping
    public String getCart(@RequestParam String name, Model model, HttpSession sess) {
        // get the cart using the business logic from CartService
        List<Item> cart = cartSvc.getCart(name);

        // save cart to current session
        sess.setAttribute("cart", cart);
        // save user name to current session
        sess.setAttribute("user", name);
        // add cart to model for view
        model.addAttribute("cart", cart);
    
        // model.addAttribute(ATTR_ITEM, new Item());
        // model.addAttribute(ATTR_CART, cart);
        // model.addAttribute(ATTR_USERNAME, name);

        return "cart";
    }

    @PostMapping
    public String postCart(@ModelAttribute Item item, HttpSession sess, Model model) {
        // retrieve cart from current session
        List<Item> cart = (List<Item>) sess.getAttribute("cart");
        // append item to current cart
        cart.add(item);

        // add cart to model for view
        model.addAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("/checkout")
    public String checkoutCart(HttpSession sess) {
        // retrieve user name and cart from session 
        String username = (String) sess.getAttribute("user");
        List<Item> cart = (List<Item>) sess.getAttribute("cart");

        // save cart to redis 
        cartSvc.save(username, cart);
        // destroy session
        sess.invalidate();

        return "redirect:/";
    }
    
}
