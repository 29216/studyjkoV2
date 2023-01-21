package app.studyjko.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "receipt", schema = "alebaza", catalog = "")
public class ReceiptEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "availableSum", nullable = true)
    private Long availableSum;
    @Basic
    @Column(name = "creationTime", nullable = true)
    private Timestamp creationTime;
    @Basic
    @Column(name = "modificationTime", nullable = false)
    private Timestamp modificationTime;
    @Basic
    @Column(name = "sum", nullable = false)
    private long sum;
    @Basic
    @Column(name = "cdId", nullable = true)
    private Long cdId;
    @Basic
    @Column(name = "trackId", nullable = true)
    private Long trackId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAvailableSum() {
        return availableSum;
    }

    public void setAvailableSum(Long availableSum) {
        this.availableSum = availableSum;
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

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptEntity that = (ReceiptEntity) o;
        return id == that.id && sum == that.sum && Objects.equals(availableSum, that.availableSum) && Objects.equals(creationTime, that.creationTime) && Objects.equals(modificationTime, that.modificationTime) && Objects.equals(cdId, that.cdId) && Objects.equals(trackId, that.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availableSum, creationTime, modificationTime, sum, cdId, trackId);
    }
}
