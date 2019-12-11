package br.com.store.controller;


import br.com.store.domain.Product;
import br.com.store.repository.ProductRepository;
import br.com.store.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductRepositoryImpl product;

    @GetMapping("/")
    public void index(){

        List<Product> products = product.findAll(); //TODO:PASSAR A LISTA DE PRODUTOS PRO FRONT

    }

    @PostMapping("/delete/{id}")
    public void delete(Long id){

        product.Delete(id);

    }

    @GetMapping("/search/{id}")
    public void search(Long id){

        Product prod = product.findOne(id); //TODO: PASSAR PRO FRONT

    }

    @PostMapping("/Update/{id}")
    public void update(Long id, float new_price){

        product.Update_price(id,new_price);
    }



}
