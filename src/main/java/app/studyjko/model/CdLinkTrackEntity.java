package app.studyjko.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cd_link_track", schema = "alebaza", catalog = "")
public class CdLinkTrackEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "cdId", nullable = false)
    private int cdId;
    @Basic
    @Column(name = "connectionKind", nullable = false, length = 70)
    private String connectionKind;
    @Basic
    @Column(name = "trackId", nullable = false)
    private int trackId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public String getConnectionKind() {
        return connectionKind;
    }

    public void setConnectionKind(String connectionKind) {
        this.connectionKind = connectionKind;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdLinkTrackEntity that = (CdLinkTrackEntity) o;
        return id == that.id && cdId == that.cdId && trackId == that.trackId && Objects.equals(connectionKind, that.connectionKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cdId, connectionKind, trackId);
    }
}
