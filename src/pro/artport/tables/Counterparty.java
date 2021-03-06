package pro.artport.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Counterparty.FindAll", query="select c from Counterparty c"),
        @NamedQuery(name = "Counterparty.FindAllFolders", query = "select c from Counterparty c where c.folder=true")
})
public class Counterparty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private String description;

    @Basic
    private String code;

    @Basic
    private boolean marked;

    @Basic
    private boolean folder;

    public Counterparty() {
    }

    public Counterparty(Boolean folder) {
        this.folder = folder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean getFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    @ManyToOne
    private Counterparty parent;

    public Counterparty getParent() {
        return parent;
    }

    public void setParent(Counterparty parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    private Collection<Counterparty> children;

    public Collection<Counterparty> getChildren() {
        return children;
    }

    public void setChildren(Collection<Counterparty> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counterparty)) return false;
        Counterparty that = (Counterparty) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "("+ code + ") " + description;
    }

    @OneToMany(mappedBy = "counterparty")
    private Collection<ReceiptOrder> orders;

    public Collection<ReceiptOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<ReceiptOrder> orders) {
        this.orders = orders;
    }

    public boolean isFolder() {
        return folder;
    }
}
