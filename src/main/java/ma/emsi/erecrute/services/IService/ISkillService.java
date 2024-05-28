package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Skill;

import java.util.List;

public interface ISkillService {
    public void addSkill(Skill skill);
    public void deleteSkill(Skill skill);
    public void updateSkill(Skill skill);
    public Skill findSkillById(Long id);
    public List<Skill> getAll();
}
