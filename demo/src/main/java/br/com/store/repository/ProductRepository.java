package br.com.store.repository;

import br.com.store.domain.ClientReport;
import br.com.store.domain.Orders;
import br.com.store.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends Repository<Product, Long> {

    List<Product> findAll();

    Product findOne(Long id_prod);

    void delete(Long id_prod);

    void update_price(Long id_prod, float new_price);

    List<Product> filterByCategory();

    List<Product> avgOfBestRatingCategories();

    List<ClientReport> clientInsatisfaction();

    List<Orders> approvedOrders();

    List<Product> filterByPrice(Boolean asc);

    List<Product> filterByRating(Boolean asc);

}