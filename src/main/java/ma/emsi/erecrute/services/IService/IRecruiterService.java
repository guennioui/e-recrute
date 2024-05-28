package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;

import java.util.List;

public interface IRecruiterService {
    public void addRecruiter(Recruiter recruiter);
    public void deleteRecruiter(Recruiter recruiter);
    public void updateRecruiter(Recruiter recruiter);
    public Recruiter findRecruiterById(Long id) throws RecruiterNotFoundException;
    public List<Recruiter> getAll();
}
