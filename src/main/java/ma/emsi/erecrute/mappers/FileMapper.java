package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.FileDto;
import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.entites.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);
    FileDto entityToDto(Resume file);
    Resume dtoToEntity(FileDto fileDto);
}
