package nus.iss.d15shoppingcart.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.d15shoppingcart.model.Item;

// manages data access operations
@Repository
public class CartRepo {

    @Autowired @Qualifier("redis") // connecting to redis; qualifier to specify which bean
    private RedisTemplate<String, String> template;

    // handles data access operation into the redis database; access redis to check if there's a key(cart) with this name
    public boolean hasCart(String name) {
        // the below returns a boolean value 
        return template.hasKey(name);
    }

    public void deleteCart(String name) {
        template.delete(name);
    }

    public void addCart(String name, List<Item> cart) {
        ListOperations<String, String> list = template.opsForList();
        cart.stream()
            .forEach(item-> {
                // creating a formatted string for each item in the list
                String formattedString = "%s,%d".formatted(item.getName(), item.getQuantity());
                // pushes the formatter string to the left end of the redis list; parameter 'name' is the name key in redis
                list.leftPush(name, formattedString);
            });
            // alternative for the stream: for(Item item: cart) {String rec = String.format(%s%d, item.getName(), item.getQuantity()); list.leftPush(name, rec);}
    }

    // getting the item from redis
    public List<Item> getCart(String name) {
        // grabbing the list from redis
        ListOperations<String, String> list = template.opsForList();

        // checking the number of items in the cart
        Long size = list.size(name);

        // providing a new bag to gather info abt the items we read from the redis list obtained
        List<Item> cart = new LinkedList<>();

        // looking through the list. retrieving values from redis list by the key 'name', start index=0, size= end index
        for(int i = 0; i< template.opsForList().size(name); i++) {
            // iterate each item in list
            String nameQty = template.opsForList().index(name, 1);
            
            //splitting the info by comma into an array of strings
            String[] terms = nameQty.split(",");

            // new item object created to hold details of the individual item 
            Item item = new Item();

            // THE 0 AND 1 are the columns in CSV

            // naming the item. terms[Utils.F_NAME] is like finding the name of the toy in the details
            item.setName(terms[0]);

            // counting the number of the particular item. parseInt cos the data was previously stored as String, need to convet back to int
            item.setQuantity(Integer.parseInt(terms[1]));

            // putting back the extracted details of the item back into my own cart list 
            cart.add(item);
        }

        return cart;
    }
}
