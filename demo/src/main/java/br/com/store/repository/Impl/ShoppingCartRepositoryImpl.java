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

    public List<ShoppingCart> findAll(Person p){

        Query query = entityManager.createQuery("select sp from shopping_cart sp where sp.person = :p ")
                .setParameter("p",p);

        return query.getResultList();


    }

    public void Insert_Cart(Product pr, Person p){



    }


}
