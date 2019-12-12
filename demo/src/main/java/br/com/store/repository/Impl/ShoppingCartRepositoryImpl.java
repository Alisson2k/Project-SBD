package br.com.store.repository.Impl;

import br.com.store.domain.Person;
import br.com.store.domain.Product;
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

    public List<ShoppingCart> findAll(Long id_person){

        Query query = entityManager.createQuery("select sp from shopping_cart sp where sp.person.id_person = :p ")
                .setParameter("p",id_person);

        return query.getResultList();

    }

    public void insert_Cart(Product pr, Person p){



    }


    public void delete_Cart(Long id_cart) {



    }

    public float subtotal(Long id_person){

        Query query = entityManager.createQuery("select vs from view_shopping_cart vs where id_person = :p ")
                .setParameter("p",id_person);

        return (float) query.getSingleResult();

    }

}