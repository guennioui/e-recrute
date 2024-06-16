package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public IUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void modifyUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found!");
        }
        return optionalUser.get();
    }

    @Override
    public User findUserByUsername(String email) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found!");
        }
        return optionalUser.get();
    }
}
