package app.studyjko.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "alebaza", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "email", nullable = false, length = 70)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 160)
    private String password;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @Basic
    @Column(name = "position", nullable = false, length = 216)
    private String position;
    @Basic
    @Column(name = "systemRole", nullable = false, length = 100)
    private String systemRole;
    @Basic
    @Column(name = "creationTime", nullable = false)
    private LocalDateTime creationTime;
    @Basic
    @Column(name = "modificationTime", nullable = true)
    private LocalDateTime modificationTime;
    @Basic
    @Column(name = "picture", nullable = true)
    private byte[] picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(position, that.position) && Objects.equals(systemRole, that.systemRole) && Objects.equals(creationTime, that.creationTime) && Objects.equals(modificationTime, that.modificationTime) && Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, email, password, name, surname, position, systemRole, creationTime, modificationTime);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
