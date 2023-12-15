package ssf.pizza.practice.ssfpracticepizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.pizza.practice.ssfpracticepizza.repo.PizzaRepo;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepo pizzaRepo;
}
