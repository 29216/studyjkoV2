package app.studyjko.data.cd;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CdDto {
    private long id;
    private LocalDateTime creationTime;
    private LocalDateTime modificationTime;
    private long userId;
    private String title;
    private String link;
    private String creator;
    private String album;

}
