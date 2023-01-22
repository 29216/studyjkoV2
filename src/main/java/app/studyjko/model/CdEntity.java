package app.studyjko.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cd", schema = "alebaza", catalog = "")
public class CdEntity {
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
    @Column(name = "creatorId", nullable = false)
    private long creatorId;
    @Basic
    @Column(name = "title", nullable = true, length = 256)
    private String title;
    @Basic
    @Column(name = "link", nullable = true, length = 256)
    private String link;

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

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdEntity cdEntity = (CdEntity) o;
        return id == cdEntity.id && creatorId == cdEntity.creatorId && Objects.equals(creationTime, cdEntity.creationTime) && Objects.equals(modificationTime, cdEntity.modificationTime) && Objects.equals(title, cdEntity.title);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, creationTime, modificationTime, creatorId, title);
        return result;
    }
}
