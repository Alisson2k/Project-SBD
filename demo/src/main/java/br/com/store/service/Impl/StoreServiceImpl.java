package br.com.store.service.Impl;

import br.com.store.domain.Person;
import br.com.store.service.StoreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String findPersonById(Long id) {
        Query query = em.createQuery("select p from person p");
        System.out.println(query);

        String text = "AAA";
        return text;
    }

    @Override
    public List<Person> findAllPersons() {
        return null;
    }
}
