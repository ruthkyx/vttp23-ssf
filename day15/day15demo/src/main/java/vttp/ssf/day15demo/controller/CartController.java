package vttp.ssf.day15demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.day15demo.Utils;
import vttp.ssf.day15demo.model.Item;

@Controller
@RequestMapping(path="/cart")
public class CartController {

    private Logger logger = Logger.getLogger(CartController.class.getName());

    public static final String ATTR_ITEM = "item";
    public static final String ATTR_CART= "cart";

    @Autowired
    public String getcart(@RequestParam String name, Model model, HttpSession sess) {
        List<Item> cart = cartSvc.getCart(name);

        logger.info("CART:%s -  %s\n". formatted(name, cart));

        sess.setAttribute(Utils.ATTR_CART, cart);

        model.addAttribute(ATTR_ITEM, new Item());
        model.addAttribute(ATTR_CART, cart);

        return "cart";
    }
    
    @PostMapping(path="/checkout")
    public ModelAndView postCartCheckout(HttpSession sess) {
        // linking from index.html to here
        ModelAndView mav = new ModelAndView("cart");

        List<Item> cart = Utils.getCart(sess);
        System.out.printf("Checking out cart: %s\n", cart);

        // to log the user out/end the session  
        sess.invalidate();

        mav.addObject(ATTR_ITEM, new Item());
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }

    @PostMapping
    public ModelAndView postCart(@Valid @ModelAttribute(ATTR_ITEM) Item item, BindingResult bindings, HttpSession sess) {
        // BindingResult MUST come after @Valid & @ModelAttribute
        // session is a map: check if data is in map, retrieve if yes. if not then instantiate new 

        System.out.printf("item: $s\n", item);
        System.out.printf("error: %b\n", bindings.hasErrors());

        // to view the index page
        ModelAndView mav = new ModelAndView("cart");

        if(bindings.hasErrors()) {
            mav.setStatus(HttpStatusCode.valueOf(400));
            return mav;
        }

        List<Item> cart = Utils.getCart(sess);
        cart.add(item);

        mav.addObject("item", new Item());
        mav.addObject(ATTR_CART, cart);

        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }
}
