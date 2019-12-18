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
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private EntityManager entityManager;


    public List<Product> findAll() throws PersistenceException {

        Query query = entityManager.createNativeQuery("SELECT * FROM PRODUCT P NATURAL JOIN PRODUCT_DETAIL PD");
        return query.getResultList();

    }

    public Object findOne(Long id_prod) throws PersistenceException {

        Query query = entityManager.createNativeQuery("SELECT * FROM PRODUCT P NATURAL JOIN PRODUCT_DETAIL PD WHERE P.id_prod = ?1")
                .setParameter(1, id_prod);

        return query.getSingleResult();
    }

    public void delete(Product p) throws PersistenceException {

        //APAGAR OS DETALHES DO PRODUTO ANTES DE APAGAR O PRODUTO EM SI , RESTRIÇÃO DE INTEGRIDADE.
        Query q = entityManager.createQuery("DELETE FROM PRODUCT_DETAIL pd WHERE pd.product =:p")
                .setParameter("p", p);

        Query query = entityManager.createQuery("DELETE  FROM PRODUCT P WHERE P.id_prod = :input_id")
                .setParameter("input_id", p.getId_prod());

    }

    public void update_price(Long id_prod, float new_price) throws PersistenceException {

        Query query = entityManager.createQuery("UPDATE PRODUCT P SET P.unit_price = :new_price WHERE P.id_prod = :input_id")
                .setParameter("input_id", id_prod)
                .setParameter("new_price", new_price);

    }

    public List<Product> filterByCategory() {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM PRODUCT P\n" +
                        "NATURAL JOIN PRODUCT_DETAIL PD\n" +
                        "WHERE P.unit_price < 1000\n" +
                        "AND PD.category = 'Eletrônicos';"
        );
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
