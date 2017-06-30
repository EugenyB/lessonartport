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

    public Counterparty find(int id) {
        return em.find(Counterparty.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Counterparty> findAllFolders() {
        return em.createNamedQuery("Counterparty.FindAllFolders").getResultList();
    }

//    public void add(Counterparty counterparty, Counterparty parentCounterparty) {
////        System.out.println(">>> counterparty: " + counterparty);
////        System.out.println(">>> parent: " + parentCounterparty);
//        em.persist(counterparty);
//        if (parentCounterparty.getId()!=null) {
//            counterparty.setParent(parentCounterparty);
//        }
//        //em.merge(parentCounterparty);
//    }
}
