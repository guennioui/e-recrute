package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Role;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface RoleService {
    public Role addRole(Role role);
    public void deleteRole(Role role);
    public Role modifyRole(Role role);
    public Role findRoleByName(String roleName) throws RoleNotFoundException;
    public Role findRoleById(Long roleId) throws RoleNotFoundException;
    public List<Role> getAllRoles();
}
