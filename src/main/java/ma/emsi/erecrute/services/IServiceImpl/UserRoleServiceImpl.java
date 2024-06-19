package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Role;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.services.IService.IUserService;
import ma.emsi.erecrute.services.IService.RoleService;
import ma.emsi.erecrute.services.IService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final IUserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRoleServiceImpl(IUserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) throws UserNotFoundException, RoleNotFoundException {
        User user = userService.findUserById(userId);
        Role role = roleService.findRoleByName(roleName);
        role.getUsers().add(user);
        user.getRoles().add(role);
        userService.modifyUser(user);
        roleService.modifyRole(role);
    }
}
