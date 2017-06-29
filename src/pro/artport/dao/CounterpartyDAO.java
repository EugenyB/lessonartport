package pro.artport.dao;

import pro.artport.tables.Counterparty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CounterpartyDAO {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Counterparty> findAll() {
//        return em.createQuery("select c from Counterparty c").getResultList();
        return em.createNamedQuery("Counterparty.FindAll").getResultList();
    }

    public void add(Counterparty counterparty) {
        em.persist(counterparty);
    }
}
