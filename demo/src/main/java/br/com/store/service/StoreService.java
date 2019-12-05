package br.com.store.service;

import br.com.store.domain.Person;
import br.com.store.domain.Store;

import java.util.List;

public interface StoreService {

    String findPersonById(Long id);

    List<Person> findAllPersons();
}
