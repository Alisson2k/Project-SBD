package br.com.store.service;

import br.com.store.domain.Person;
import br.com.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public String findPersonById(Long id) {
        System.out.println(storeRepository.findAll());

        String text = "AAA";
        return text;
    }

    @Override
    public List<Person> findAllPersons() {
        return null;
    }
}
