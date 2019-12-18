package br.com.store.repository.Impl;

import br.com.store.domain.ClientReport;
import br.com.store.domain.Orders;
import br.com.store.domain.Product;
import br.com.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private EntityManager entityManager;


    public List<Product> findAll() throws PersistenceException {

        Query query = entityManager.createNativeQuery("SELECT * FROM PRODUCT P INNER JOIN PRODUCT_DETAIL PD ON P.id_prod = PD.product_id_prod");
        return query.getResultList();

    }

    public Object findOne(Long id_prod) throws PersistenceException {

        Query query = entityManager.createNativeQuery("SELECT * FROM PRODUCT P INNER JOIN PRODUCT_DETAIL PD ON P.id_prod = PD.product_id_prod WHERE P.id_prod = ?1")
                .setParameter(1, id_prod);

        return query.getSingleResult();
    }

    public void delete(Long id_prod) throws PersistenceException {


        //APAGAR OS DETALHES DO PRODUTO ANTES DE APAGAR O PRODUTO EM SI , RESTRIÇÃO DE INTEGRIDADE

        int deletecoun = entityManager.createNativeQuery("DELETE PD FROM PRODUCT_DETAIL PD INNER JOIN PRODUCT P ON PD.product_id_prod = P.id_prod WHERE P.id_prod = ?1")
                .setParameter(1,id_prod).executeUpdate();

        int deleteCount = entityManager.createQuery("DELETE FROM PRODUCT P WHERE P.id_prod = ?1")
                .setParameter(1, id_prod).executeUpdate();


    }

    public void update_price(Long id_prod, float new_price) throws PersistenceException {

        int updatePrice = entityManager.createNativeQuery("UPDATE PRODUCT SET unit_price = ?1 WHERE id_prod = ?2")
                .setParameter(2, id_prod)
                .setParameter(1, new_price).executeUpdate();

    }

    public List<Product> filterByCategory(String category) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM PRODUCT P\n" +
                        " INNER JOIN PRODUCT_DETAIL PD on P.id_prod = PD.product_id_prod\n" +
                        " WHERE PD.category = ?1"
        ).setParameter(1,category);
        return query.getResultList();
    }

    public List<Product> avgOfBestRatingCategories() {
        Query query = entityManager.createNativeQuery(
                "SELECT category , avg(unit_price)\n" +
                        "FROM PRODUCT\n" +
                        "NATURAL JOIN PRODUCT_DETAIL\n" +
                        " GROUP BY category\n" +
                        " HAVING avg(rating) > 5;"
        );

        return query.getResultList();
    }

    public List<ClientReport> clientInsatisfaction() {
        Query query = entityManager.createNativeQuery(
                "SELECT count(id_person) as \"Clientes Insatisfeitos\" FROM CLIENT_REPORT\n" +
                        "NATURAL JOIN PERSON\n" +
                        " WHERE satisfaction_level > 3\n" +
                        "\n" +
                        " UNION\n" +
                        "\n" +
                        "SELECT email FROM CLIENT_REPORT\n" +
                        "NATURAL JOIN PERSON\n" +
                        " WHERE satisfaction_level > 3;"
        );

        return query.getResultList();
    }

    public List<Orders> approvedOrders() {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM ORDERS\n" +
                        "NATURAL JOIN PRODUCT\n" +
                        " WHERE order_state = \"Aprovado\"\n" +
                        " AND type_of_payment = \"C\"\n" +
                        " ORDER BY order_date asc;"
        );

        return query.getResultList();
    }

    public List<Product> filterByPrice(Boolean asc) {
        Query query = asc ? entityManager.createNativeQuery(
                "SELECT * FROM PRODUCT\n" +
                        "ORDER BY unit_price asc;") :
                entityManager.createNativeQuery(
                        "SELECT * FROM PRODUCT\n" +
                                "ORDER BY unit_price desc;");

        return query.getResultList();
    }


    public List<Product> filterByRating(Boolean asc) {
        Query query = asc ? entityManager.createNativeQuery(
                "SELECT * FROM PRODUCT\n" +
                        "ORDER BY rating asc;") :
                entityManager.createNativeQuery(
                        "SELECT * FROM PRODUCT\n" +
                                "ORDER BY rating desc;");

        return query.getResultList();
    }
}
