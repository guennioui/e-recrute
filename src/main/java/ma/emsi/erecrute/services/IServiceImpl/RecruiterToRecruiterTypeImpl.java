package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.RecruiterType;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.IRecruiterTypeService;
import ma.emsi.erecrute.services.IService.RecruiterToRecruiterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecruiterToRecruiterTypeImpl implements RecruiterToRecruiterType {
    private final IRecruiterService recruiterService;
    private final IRecruiterTypeService recruiterTypeService;

    @Autowired
    public RecruiterToRecruiterTypeImpl(IRecruiterService recruiterService, IRecruiterTypeService recruiterTypeService) {
        this.recruiterService = recruiterService;
        this.recruiterTypeService = recruiterTypeService;
    }

    @Override
    public void addRecruiterToRecruiterType(Long recruiter_id, Long recruiter_type_id) throws RecruiterNotFoundException, RecruiterTypeNotFoundException {
        Recruiter recruiterById = this.recruiterService.findRecruiterById(recruiter_id);
        RecruiterType recruiterTypeById = this.recruiterTypeService.findRecruiterTypeById(recruiter_type_id);
        recruiterById.setRecruiterType(recruiterTypeById);
        recruiterTypeById.setRecruiter(recruiterById);
    }
}
