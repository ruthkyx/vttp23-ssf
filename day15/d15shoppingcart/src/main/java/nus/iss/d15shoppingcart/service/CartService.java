package nus.iss.d15shoppingcart.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.d15shoppingcart.model.Item;
import nus.iss.d15shoppingcart.repo.CartRepo;

// for business logic; set of rules for the app to work 
@Service
public class CartService {
    
    @Autowired
    private CartRepo cartRepo; 

    // if yes the cart for this user exists, return the items in the cart, if nt then return empty list
    public List<Item> getCart(String name) {
        List<Item> cart;
        if(cartRepo.hasCart(name)) {
            cart = cartRepo.getCart(name);
        } else {
            cart = new LinkedList<>();
        }
        return cart;
    }

    public void save(String name, List<Item> cart) {
        cartRepo.deleteCart(name);
        cartRepo.addCart(name, cart);
        // when saved, any add or delete operation is executed 
    }
}
