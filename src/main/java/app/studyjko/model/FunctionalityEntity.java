package app.studyjko.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "functionality", schema = "p38tSDIPVV", catalog = "")
public class FunctionalityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "availableInDemo", nullable = false)
    private byte availableInDemo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAvailableInDemo() {
        return availableInDemo;
    }

    public void setAvailableInDemo(byte availableInDemo) {
        this.availableInDemo = availableInDemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionalityEntity that = (FunctionalityEntity) o;
        return id == that.id && availableInDemo == that.availableInDemo && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, availableInDemo);
    }
}
