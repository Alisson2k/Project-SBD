package br.com.store.repository;

import br.com.store.domain.Person;
import br.com.store.domain.Product;
import br.com.store.domain.ShoppingCart;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ShoppingCartRepository extends Repository<Product, Long> {

    List<ShoppingCart> findAll(Person p);

    void Insert_Cart(Product pr,Person p);

    void Delete_Cart(Long id_cart);

}
