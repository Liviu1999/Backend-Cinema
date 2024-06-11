package cinema.demo.services;

import cinema.demo.api.model.User;
import cinema.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser;
        }
        System.out.println("Employee with id: {} doesn't exist" + id);

        return Optional.empty();
    }

    public User saveUser (User user){
        User savedEmployee = userRepo.save(user);

        System.out.println("Employee with id: {} saved successfully" + user.getId());
        return savedEmployee;
    }

    public User addUser(User user){
        Optional<User> existingEmployee = userRepo.findById(user.getId());

        User updatedEmployee = userRepo.save(user);

        System.out.println("Employee with id: {} updated successfully" +  user.getId());
        return updatedEmployee;
    }
}
