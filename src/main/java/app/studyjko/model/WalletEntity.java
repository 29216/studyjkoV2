package app.studyjko.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "p38tSDIPVV", catalog = "")
public class WalletEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "availableSum", nullable = true)
    private Long availableSum;
    @Basic
    @Column(name = "lockedSum", nullable = true)
    private Long lockedSum;
    @Basic
    @Column(name = "creationTime", nullable = true)
    private Timestamp creationTime;
    @Basic
    @Column(name = "modificationTime", nullable = false)
    private Timestamp modificationTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAvailableSum() {
        return availableSum;
    }

    public void setAvailableSum(Long availableSum) {
        this.availableSum = availableSum;
    }

    public Long getLockedSum() {
        return lockedSum;
    }

    public void setLockedSum(Long lockedSum) {
        this.lockedSum = lockedSum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return id == that.id && Objects.equals(availableSum, that.availableSum) && Objects.equals(lockedSum, that.lockedSum) && Objects.equals(creationTime, that.creationTime) && Objects.equals(modificationTime, that.modificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availableSum, lockedSum, creationTime, modificationTime);
    }
}
