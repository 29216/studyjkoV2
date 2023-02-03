package app.studyjko.data.cd;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CdDto {
    private long id;
    private LocalDateTime creationTime;
    private LocalDateTime modificationTime;
    private long userId;
    private String title;
    private String link;

    public CdDto(String title) {
        this.creationTime = LocalDateTime.now();
        this.modificationTime = LocalDateTime.now();
        this.userId = 1;
        this.title = title;
        this.link = "link";
    }
}
