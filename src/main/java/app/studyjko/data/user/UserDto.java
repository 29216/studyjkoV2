package app.studyjko.data.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String position;
    private String systemRole;
    private LocalDateTime creationTime;
    private LocalDateTime modificationTime;
    private byte[] picture;
}
