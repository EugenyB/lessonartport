package pro.artport.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "ReceiptOrder.FindAll", query = "select r from ReceiptOrder r")
})
public class ReceiptOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    private Date date;

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        return String.format("%1$te %1$tB %1$tY", date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    private boolean marked;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Basic
    private boolean posted;

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    @ManyToOne(optional = false)
    private Counterparty counterparty;

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    @ManyToOne(optional = false)
    private Storage storage;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @OneToMany(mappedBy = "receiptOrder")
    private Collection<ReceiptOrderGood> goods;

    public Collection<ReceiptOrderGood> getGoods() {
        return goods;
    }

    public void setGoods(Collection<ReceiptOrderGood> goods) {
        this.goods = goods;
    }
}
