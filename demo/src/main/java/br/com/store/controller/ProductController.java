package br.com.store.controller;

import br.com.store.domain.Product;
import br.com.store.repository.Impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepositoryImpl product;

    private EntityManager entityManager;

    @GetMapping("/")
    public void index(){

        Query query = entityManager.createQuery("BEGIN TRANSACTION");

        try {

            List<Product> products = product.findAll();
            entityManager.createQuery("COMMIT");

        }catch (PersistenceException e){

            entityManager.createQuery("ROLLBACK");

        }
    }

    @GetMapping("/filter/byprice")
    public void filter(){




    }


    @GetMapping("/search/{id}")
    public void search(Long id){

        Product prod = product.findOne(id);

    }


    @PostMapping("/delete/{id}")
    public void delete(Long id){

        product.delete(id);

    }

    @PostMapping("/update/{id}")
    public void update(Long id, float new_price){

        product.update_price(id,new_price);
    }




}
