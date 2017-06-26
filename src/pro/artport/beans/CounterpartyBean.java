package pro.artport.beans;

import pro.artport.dao.CounterpartyDAO;
import pro.artport.tables.Counterparty;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class CounterpartyBean {
    @EJB
    CounterpartyDAO counterpartyDAO;

    public List<Counterparty> getCounterparties() {
        return counterpartyDAO.findAll();
    }
}
