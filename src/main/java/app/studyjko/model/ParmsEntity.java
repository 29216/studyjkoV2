package app.studyjko.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "parms", schema = "p38tSDIPVV", catalog = "")
public class ParmsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "key", nullable = false, length = 255)
    private String key;
    @Basic
    @Column(name = "value", nullable = false, length = 2048)
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParmsEntity that = (ParmsEntity) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
