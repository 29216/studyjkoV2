package app.studyjko.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "creator", schema = "alebaza", catalog = "")
public class CreatorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "creationTime", nullable = true)
    private Timestamp creationTime;
    @Basic
    @Column(name = "modificationTime", nullable = false)
    private Timestamp modificationTime;
    @Basic
    @Column(name = "userId", nullable = false)
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Timestamp modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatorEntity that = (CreatorEntity) o;
        return id == that.id && userId == that.userId && Objects.equals(creationTime, that.creationTime) && Objects.equals(modificationTime, that.modificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationTime, modificationTime, userId);
    }
}
