package app.studyjko.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private LocalDateTime creationTime;
    @Basic
    @Column(name = "modificationTime", nullable = false)
    private LocalDateTime modificationTime;
    @Basic
    @Column(name = "userId", nullable = false)
    private long userId;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdEntity cdEntity = (CdEntity) o;
        return id == cdEntity.id && userId == cdEntity.userId && Objects.equals(creationTime, cdEntity.creationTime) && Objects.equals(modificationTime, cdEntity.modificationTime) && Objects.equals(title, cdEntity.title);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, creationTime, modificationTime, userId, title);
        return result;
    }

    public String toString() {
        return this.getTitle();
    }
}
