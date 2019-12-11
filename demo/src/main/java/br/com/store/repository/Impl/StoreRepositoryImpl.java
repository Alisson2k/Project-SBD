package br.com.store.repository.Impl;

import br.com.store.domain.Person;
import br.com.store.repository.StoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class StoreRepositoryImpl implements StoreRepository {

    @PersistenceContext
    private EntityManager em;

    public List<String> findTeste() {

        Query query = em.createQuery("select p from person p");
        System.out.println(query);
        return query.getResultList();
    }
}
