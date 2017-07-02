package pro.artport.beans;

import pro.artport.dao.CounterpartyDAO;
import pro.artport.tables.Counterparty;
import pro.artport.tables.Nomenclature;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class CounterpartyBean implements Serializable {
    @EJB
    private CounterpartyDAO counterpartyDAO;

    private Counterparty counterparty = new Counterparty();
    private Counterparty parentCounterparty = new Counterparty();

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public Counterparty getParentCounterparty() {
        return parentCounterparty;
    }

    public void setParentCounterparty(Counterparty parentCounterparty) {
        this.parentCounterparty = parentCounterparty;
    }

    public List<Counterparty> getCounterparties() {
        return counterpartyDAO.findAll();
    }

    public void add() {
        counterpartyDAO.add(counterparty);//, parentCounterparty);
        counterparty = new Counterparty();
    }

    public List<Counterparty> completeParent(String query) {
        List<Counterparty> allParents = counterpartyDAO.findAllFolders();
        List<Counterparty> filteredParents = allParents.stream()
                .filter(p -> p.getDescription().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        return filteredParents;
    }
}
