package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.UserNotFoundException;

import javax.management.relation.RoleNotFoundException;

public interface IUserService {
    public void modifyUser(User user);
    public User findUserById(Long id) throws UserNotFoundException;
    public User findUserByUsername(String email) throws UserNotFoundException;
}
