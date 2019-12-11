package br.com.store.repository.Impl;

import br.com.store.domain.Product;
import br.com.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Product> findAll() throws PersistenceException {

        Query query = entityManager.createQuery("SELECT P FROM product P inner join product_detail pd on pd.id_prod = P.idprod");
        return query.getResultList();

    }

    public Product findOne(Long id_prod) throws PersistenceException {

        Query query = entityManager.createQuery("SELECT P FROM product P inner join product_detail pd on pd.id_prod = P.idprod WHERE P.id_prod = :input_id")
                .setParameter("input_id",id_prod);

        return (Product) query.getSingleResult();
    }

    public void Delete(Long id_prod) throws PersistenceException {

        //APAGAR OS DETALHES DO PRODUTO ANTES DE APAGAR O PRODUTO EM SI , RESTRIÇÃO DE INTEGRIDADE.
        Query q = entityManager.createQuery("DELETE FROM product_detail pd WHERE pd.id_prod =:input_id")
                .setParameter("input_id",id_prod);

        Query query = entityManager.createQuery("DELETE  FROM product P WHERE P.id_prod = :input_id")
                .setParameter("input_id",id_prod);

    }

    public void Update_price(Long id_prod, float new_price) throws PersistenceException {

        Query query = entityManager.createQuery("UPDATE product P SET P.unit_price = :new_price WHERE P.id_prod = :input_id")
                .setParameter("input_id",id_prod)
                .setParameter("new_price",new_price);

    }

}
