package br.com.store.controller;

import br.com.store.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreServiceImpl storeService;

    @RequestMapping(name = "/")
    public void index() {
        System.out.println("Entrou aqui!");
        storeService.findAllProducts();
    }
}
