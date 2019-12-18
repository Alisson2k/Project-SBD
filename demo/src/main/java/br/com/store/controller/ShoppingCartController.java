package br.com.store.controller;

import br.com.store.domain.ShoppingCart;
import br.com.store.repository.Impl.ShoppingCartRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Cart")
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepositoryImpl cart;

    @GetMapping("/{id}")
    public List<ShoppingCart> index(@PathVariable("id") Long id_person){

        List<ShoppingCart> sp = cart.findAll(id_person);

        return sp;

    }

    @PostMapping("/total/{id}")
    public float subtotal(@PathVariable("id") Long id_person){

        float total = cart.subtotal(id_person);

        return total;
    }
}