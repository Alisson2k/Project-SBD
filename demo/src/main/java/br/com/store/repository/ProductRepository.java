package br.com.store.repository;

import br.com.store.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends Repository<Product, Long> {

    List<Product> findAll();

    Product findOne(Long id_prod);

    void Delete(Long id_prod);

    void Update_price(Long id_prod, float new_price);


}
