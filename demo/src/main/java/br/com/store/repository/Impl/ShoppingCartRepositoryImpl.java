package br.com.store.repository.Impl;

import br.com.store.domain.ShoppingCart;
import br.com.store.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {


    @Autowired
    private EntityManager entityManager;

    public List<ShoppingCart> findAll(Long id_person) {

        Query query = entityManager.createNativeQuery("SELECT * FROM SHOPPING_CART SP WHERE SP.person_id_person = ?1")
                .setParameter(1, id_person);

        return query.getResultList();

    }


    public Object subtotal(Long id_person) {

        Query query = entityManager.createNativeQuery("SELECT * FROM view_shopping_cart  WHERE person_id_person = ?1 ")
                .setParameter(1, id_person);

        return query.getSingleResult();

    }
}