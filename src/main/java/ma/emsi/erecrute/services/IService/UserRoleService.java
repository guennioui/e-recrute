package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.UserNotFoundException;

import javax.management.relation.RoleNotFoundException;

public interface UserRoleService {
    public void addRoleToUser(Long userId, String roleName) throws UserNotFoundException, RoleNotFoundException;
}
