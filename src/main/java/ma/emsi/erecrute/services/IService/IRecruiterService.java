package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Recruiter;

import java.util.List;

public interface IRecruiterService {
    public void addRecruiter(Recruiter location);
    public void deleteRecruiter(Recruiter location);
    public void updateRecruiter(Recruiter location);
    public Recruiter findRecruiterById(Long id);
    public List<Recruiter> getAll();
}
