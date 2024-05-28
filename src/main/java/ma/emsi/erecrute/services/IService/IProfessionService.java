package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.entites.Profession;

import java.util.List;

public interface IProfessionService {
    public void addProfession(Profession profession);
    public void deleteProfession(Profession profession);
    public void updateProfession(Profession profession);
    public Profession findProfessionById(Long id);
    public List<Profession> getAll();
}
