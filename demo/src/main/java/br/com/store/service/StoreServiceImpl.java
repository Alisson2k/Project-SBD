package br.com.store.service;

import br.com.store.domain.Store;
import br.com.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAllProducts() {
        List<Store> products = new ArrayList<>();
        try {
            System.out.println(storeRepository.findAll());
            products = storeRepository.findAll();
            System.out.println(products);
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
        return products;
    }
}
