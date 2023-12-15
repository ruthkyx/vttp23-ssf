package ssf.pizza.practice.ssfpracticepizza.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepo {
    @Autowired
    private RedisTemplate<String,String> template;
}
