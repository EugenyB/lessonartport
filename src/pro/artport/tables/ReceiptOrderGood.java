package pro.artport.tables;

import javax.persistence.*;

@Entity
public class ReceiptOrderGood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    private int stringNumber;

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }

    @Basic
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(optional = false)
    private ReceiptOrder receiptOrder;

    public ReceiptOrder getReceiptOrder() {
        return receiptOrder;
    }

    public void setReceiptOrder(ReceiptOrder receiptOrder) {
        this.receiptOrder = receiptOrder;
    }

    @ManyToOne(optional = false)
    private Nomenclature nomenclature;

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    @Override
    public String toString() {
        return "ReceiptOrderGood{" +
                "id=" + id +
                ", stringNumber=" + stringNumber +
                ", quantity=" + quantity +
                '}';
    }
}
