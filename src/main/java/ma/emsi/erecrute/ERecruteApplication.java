package ma.emsi.erecrute;

import ma.emsi.erecrute.entites.Role;
import ma.emsi.erecrute.services.IService.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ERecruteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ERecruteApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(RoleService roleService){
//        return args -> {
//            roleService.addRole(Role.builder().roleName("CANDIDATE").build());
//            roleService.addRole(Role.builder().roleName("RECRUITER").build());
//        };
//    }


}
