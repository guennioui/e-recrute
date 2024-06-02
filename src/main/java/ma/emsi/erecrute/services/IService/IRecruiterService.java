package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.RecruiterDto;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.mappers.RecruiterMapper;

import java.util.List;

public interface IRecruiterService {
    public void addRecruiter(Recruiter recruiter);
    public void deleteRecruiter(Recruiter recruiter);
    public void updateRecruiter(Recruiter recruiter);
    public Recruiter findRecruiterById(Long id) throws RecruiterNotFoundException;
    public List<Recruiter> getAll();
    public Recruiter convertToEntity(RecruiterDto recruiterDto);
    public RecruiterDto convertToDto(Recruiter recruiter);
}
