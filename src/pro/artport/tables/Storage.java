package pro.artport.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Storage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private String description;

    @Basic
    private String code;

    @Basic
    private Boolean marked;

    @Basic
    private Boolean folder;

    public Storage() {
    }

    public Storage(Boolean folder) {
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

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Boolean isFolder() {
        return folder;
    }

    public void setFolder(Boolean folder) {
        this.folder = folder;
    }

    @ManyToOne
    private Storage parent;

    public Storage getParent() {
        return parent;
    }

    public void setParent(Storage parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    private Collection<Storage> children;

    public Collection<Storage> getChildren() {
        return children;
    }

    public void setChildren(Collection<Storage> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage that = (Storage) o;
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

    @OneToMany(mappedBy = "storage")
    private Collection<ReceiptOrder> orders;

    public Collection<ReceiptOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<ReceiptOrder> orders) {
        this.orders = orders;
    }
}
