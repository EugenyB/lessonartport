package pro.artport.beans;

import pro.artport.dao.NomenclatureDAO;
import pro.artport.dao.ReceiptOrderDAO;
import pro.artport.dao.ReceiptOrderGoodsDAO;
import pro.artport.tables.Nomenclature;
import pro.artport.tables.ReceiptOrder;
import pro.artport.tables.ReceiptOrderGood;

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
    @EJB
    NomenclatureDAO nomenclatureDAO;
    @EJB
    ReceiptOrderGoodsDAO goodsDAO;

    private ReceiptOrder ro;
    private Nomenclature nomenclature;
    private int quantity;
    private int stringNumber;

    public List<Nomenclature> getNomenclatures() {
        return nomenclatureDAO.findAll();
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

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

    public void addNomenclatureToOrder() {
        ReceiptOrderGood receiptOrderGood = new ReceiptOrderGood();
        receiptOrderGood.setNomenclature(nomenclature);
        receiptOrderGood.setQuantity(quantity);
        receiptOrderGood.setReceiptOrder(ro);
        receiptOrderGood.setStringNumber(stringNumber);
        System.out.println(">>> " + receiptOrderGood);
        goodsDAO.add(receiptOrderGood);
    }

}
