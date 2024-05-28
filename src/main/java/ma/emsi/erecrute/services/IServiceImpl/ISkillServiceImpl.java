package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Skill;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;
import ma.emsi.erecrute.repositories.SkillRepository;
import ma.emsi.erecrute.services.IService.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ISkillServiceImpl implements ISkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public ISkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void addSkill(Skill skill) {
        this.skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Skill skill) {
        this.skillRepository.delete(skill);
    }

    @Override
    public void updateSkill(Skill skill) {
        this.skillRepository.save(skill);
    }

    @Override
    public Skill findSkillById(Long id) throws SkillNotFoundException {
        Optional<Skill> optionalSkill = this.skillRepository.findById(id);
        if(optionalSkill.isEmpty()){
            throw new SkillNotFoundException("Skill not found Exception!");
        }
        return optionalSkill.get();
    }

    @Override
    public List<Skill> getAll() {
        return this.skillRepository.findAll();
    }
}
