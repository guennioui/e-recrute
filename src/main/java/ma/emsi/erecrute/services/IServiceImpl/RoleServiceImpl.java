package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Role;
import ma.emsi.erecrute.repositories.RoleRepository;
import ma.emsi.erecrute.services.IService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
         this.roleRepository.delete(role);
    }

    @Override
    public Role modifyRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role findRoleByName(String roleName) throws RoleNotFoundException{
        Optional<Role> optionalRole = roleRepository.findByRoleName(roleName);
        if(optionalRole.isEmpty()){
            throw new RoleNotFoundException("");
        }else{
            return optionalRole.get();
        }
    }

    @Override
    public Role findRoleById(Long roleId) throws RoleNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if(optionalRole.isEmpty()){
            throw new RoleNotFoundException("Role not found!");
        }else{
            return optionalRole.get();
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }
}
