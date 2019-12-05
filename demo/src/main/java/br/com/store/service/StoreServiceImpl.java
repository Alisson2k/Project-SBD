package br.com.store.service;

import br.com.store.domain.Person;
import br.com.store.domain.Store;
import br.com.store.repository.StoreRepository;
import br.com.store.repository.StoreRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
