package pro.artport.dao;

import pro.artport.tables.ReceiptOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReceiptOrderDAO {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<ReceiptOrder> findAll() {
        return em.createNamedQuery("ReceiptOrder.FindAll").getResultList();
    }
}
