package br.com.store.repository;


import br.com.store.domain.Product;
import br.com.store.domain.ShoppingCart;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ShoppingCartRepository extends Repository<Product, Long> {

    List<ShoppingCart> findAll(Long id_person);

    Object subtotal(Long id_person);

}
