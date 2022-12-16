package app.studyjko.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_link_cd", schema = "p38tSDIPVV", catalog = "")
public class UserLinkCdEntity {
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
    @Column(name = "userId", nullable = false)
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLinkCdEntity that = (UserLinkCdEntity) o;
        return id == that.id && cdId == that.cdId && userId == that.userId && Objects.equals(connectionKind, that.connectionKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cdId, connectionKind, userId);
    }
}
