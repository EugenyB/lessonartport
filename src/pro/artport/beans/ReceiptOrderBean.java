package pro.artport.beans;

import pro.artport.dao.ReceiptOrderDAO;
import pro.artport.tables.ReceiptOrder;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ReceiptOrderBean implements Serializable {
    @EJB
    ReceiptOrderDAO receiptOrderDAO;

    private ReceiptOrder ro;

    public ReceiptOrder getRo() {
        return ro;
    }

    public void setRo(ReceiptOrder ro) {
        this.ro = ro;
    }

    public List<ReceiptOrder> getReceiptOrders() {
        return receiptOrderDAO.findAll();
    }

    public String show(ReceiptOrder ro) {
        this.ro = ro;
        return "receiptorderdocform";
    }
}
