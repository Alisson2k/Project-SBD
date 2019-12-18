package br.com.store.controller;

import br.com.store.domain.Product;
import br.com.store.repository.Impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/filter/{category}")
    public List<Product> filterByCategory(@PathVariable("category") String category){

        List<Product> pr = product.filterByCategory(category);

        return pr;

    }


    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){

        product.delete(id);

    }

    @PostMapping("/update/{id}/{price}")
    public void update(@PathVariable("id") Long id,@PathVariable("price") float new_price){

        product.update_price(id,new_price);

    }
}
