package pro.artport.dao;

import pro.artport.tables.ReceiptOrderGood;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReceiptOrderGoodsDAO {
    @PersistenceContext
    EntityManager em;

    // TODO дописать добавление
    public void add(ReceiptOrderGood rog) {
        em.persist(rog);
    }
}
