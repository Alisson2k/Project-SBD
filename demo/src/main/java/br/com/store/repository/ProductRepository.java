package br.com.store.repository;

import br.com.store.domain.Orders;
import br.com.store.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends Repository<Product, Long> {

    List<Product> findAll();

    Product findOne(Long id_prod);

    List<Product> select1();

    List<Product> select2();

    List<ClientReport> select3();

    List<Product> select4();

    List<Product> select5();

    List<Product> select6();

    List<Product> select7();

    void delete(Long id_prod);

    void update_price(Long id_prod, float new_price);
}
