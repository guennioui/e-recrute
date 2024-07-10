package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long fileId;
    protected String fileName;
    protected double size;
    protected String filePath;
    @ManyToOne(fetch = FetchType.EAGER)
    protected User user;

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
