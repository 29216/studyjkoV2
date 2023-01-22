package app.studyjko.data.cd;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CdDto {
    private long id;
    private Timestamp creationTime;
    private Timestamp modificationTime;
    private long creatorId;
    private String title;
    private String link;
}
