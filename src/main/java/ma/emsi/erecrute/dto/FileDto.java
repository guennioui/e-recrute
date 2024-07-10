package ma.emsi.erecrute.dto;

import lombok.Data;

@Data
public class FileDto {
    protected Long fileId;
    protected String fileName;
    protected double size;
    protected String filePath;
}
