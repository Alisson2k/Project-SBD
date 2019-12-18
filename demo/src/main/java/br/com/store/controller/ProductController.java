package br.com.store.controller;

import br.com.store.domain.Product;
import br.com.store.repository.Impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping(value = "/products",method = RequestMethod.GET)
public class ProductController {

    @Autowired
    private ProductRepositoryImpl product;


    @GetMapping("/")
    public List<Product> index(){

        return product.findAll();
    }


    @GetMapping("/find/{id}")
    public Object findOne(@PathVariable("id") Long id){

        Object pr =  product.findOne(id);

        return pr;

    }

    @GetMapping("/filter/byprice")
    public List<Product> filter(){

        List<Product> pr = product.filterByPrice(true);

        return pr;

    }

    @GetMapping("/filter/byrating")
    public List<Product> filterByRating(){

        List<Product> pr = product.filterByRating(true);

        return pr;

    }

    @GetMapping("/filter/bycategory")
    public List<Product> filterByCategory(){

        List<Product> pr = product.filterByCategory();

        return pr;

    }


    @GetMapping("/search/{id}")
    public Product search(@PathVariable("id") Long id){

        Product prod = (Product) product.findOne(id);

        return prod;

    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){

        product.delete(id);

    }

    @PostMapping("/update/{id}")
    public void update(Long id, float new_price){

        product.update_price(id,new_price);
    }
}
