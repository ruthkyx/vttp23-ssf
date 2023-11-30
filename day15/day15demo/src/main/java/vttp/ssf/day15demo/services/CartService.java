package vttp.ssf.day15demo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vttp.ssf.day15demo.repositories.CartRepository;;

@Service
public class CartService {
    @Autowired @Qualifier(Utils.BEAN_REDIS)
    private RedisTemplate<String, String> template;

    public void getCart(String name) {
        if (cartRepo.hasCart(name)) {
            // return the cart if it exists, otherwise indcate that there's no cart
            return cartRepo.getCart(name);
            return new LinkedList<>();
        }
        
        
    }

    public void save(String anem, List<Item> cart) {
        cartRepo.deleteCart(name);
        cartRepo.addCart(name);
    }
}
