package pro.artport.tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Nomenclature {
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

    public Nomenclature() {
    }

    public Nomenclature(Boolean folder) {
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
    private Nomenclature parent;

    public Nomenclature getParent() {
        return parent;
    }

    public void setParent(Nomenclature parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    private Collection<Nomenclature> children;

    public Collection<Nomenclature> getChildren() {
        return children;
    }

    public void setChildren(Collection<Nomenclature> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nomenclature)) return false;
        Nomenclature that = (Nomenclature) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("(%s) %s", code, description);
    }
}
