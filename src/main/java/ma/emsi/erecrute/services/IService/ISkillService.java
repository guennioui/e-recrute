package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Skill;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;

import java.util.List;

public interface ISkillService {
    public void addSkill(Skill skill);
    public void deleteSkill(Long skillId) throws SkillNotFoundException;
    public void updateSkill(Long skillId, Skill skill) throws SkillNotFoundException;
    public Skill findSkillById(Long id) throws SkillNotFoundException;
    public List<Skill> getAll();
}
