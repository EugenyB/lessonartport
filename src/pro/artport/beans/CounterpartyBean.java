package pro.artport.beans;

import pro.artport.dao.CounterpartyDAO;
import pro.artport.tables.Counterparty;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CounterpartyBean implements Serializable {
    @EJB
    private CounterpartyDAO counterpartyDAO;

    private Counterparty counterparty = new Counterparty();

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public List<Counterparty> getCounterparties() {
        return counterpartyDAO.findAll();
    }

    public String add() {
        counterpartyDAO.add(counterparty);
        counterparty = new Counterparty();
        return "counterparties";
    }
}
