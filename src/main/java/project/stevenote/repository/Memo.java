package project.stevenote.repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 150)
    private String fileName;

    @Column(length = 300)
    private String filePath;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

}
