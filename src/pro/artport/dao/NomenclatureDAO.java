package pro.artport.dao;

import pro.artport.tables.Nomenclature;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NomenclatureDAO {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Nomenclature> findAll() {
        return em.createNamedQuery("Nomenclature.FindAll").getResultList();
    }

    public Nomenclature find(int n) {
        return em.find(Nomenclature.class, n);
    }
}
