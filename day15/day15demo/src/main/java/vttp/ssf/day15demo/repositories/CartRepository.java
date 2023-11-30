package vttp.ssf.day15demo.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.day15demo.Utils;
import vttp.ssf.day15demo.model.Item;

@Repository
public class CartRepository {
    @Autowired @Qualifier(Utils.BEAN_REDIS)
    private RedisTemplate <String, String> template;

    public boolean hasCart(String name) {
        return template.hasKey(name);
    }

    public void deleteCart(String name) {
        template.delete(name);
    }

    public void addCart(String name, List<Item> cart) {
        ListOperations<String, String> list = template.opsForList();
        cart.stream()
            .forEach(item -> {
                list.leftPush(name, "%s,%d".formatted(item.getName(), item.getQuantity()));
            });
    }

    public Item getCart(String name) {
        // HashOperations<String, String, String> hashOps = template.opsForHash();
        // // name - string, qty - integer
        // Map <String, String> values = hashOps.entries(name);
        // Item item = new Item();
        // item.setName(values.get(Utils.F_NAME));
        // item.setQuantity(Integer.parseInt(values.get(Utils.F_QUANTITY)));
        
        // return item; +> cant use hashOps cos each item has 2 fields. use CSV instead

        ListOperations<String, String> list = template.opsForList();
        Long size = list.size(name);
        List<Item> cart = new LinkedList<>();
        for(String i: list.range(name, 0, size)) {
            String[] terms = i.split(",");
            Item item = new Item();
            item.setName(terms[Utils.F_NAME]);
            item.setQuantity(Integer.parseInt(terms[Utils.F_QUANTITY]));
            cart.add(item);
        }
        return null;
    }
}
