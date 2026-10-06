package com.isak.footballapp.service;
import com.isak.footballapp.entity.User;
import com.isak.footballapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    //App-spesifikke metoder: registerUser(), findUserById(), findUserByName(),deleteUserById(), deleteUserByName()

    //Register User
    public User registerUser(User user){
        Optional <User> existingUser = userRepository.findUserByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new IllegalArgumentException("This email is already registered");
        }
        return userRepository.save(user);
    }

    //findUserById
    public User findUserById(Long id){
        Optional <User> existingUser = userRepository.findById(id);
        if(existingUser.isEmpty()){
            throw new IllegalArgumentException("This user does not exist");
        }
        return existingUser.get();
    }

        //findUserByName
        public User findUserByName(String userName){
            Optional <User> existingUser = userRepository.findByUserName(userName);
            if(existingUser.isEmpty()){
                throw new IllegalArgumentException("This user does not exist");
            }
            return existingUser.get();
        }

        public User deleteUserById(Long id){
            Optional<User> existingUser = userRepository.findById(id);
            if(existingUser.isEmpty()){
                throw new IllegalArgumentException("This user does not exist");
            }
            userRepository.delete(existingUser.get());
            return existingUser.get();
        }

        //deleteUserByName
        public User deleteUserByName(String userName){
            Optional<User> existingUser = userRepository.findByUserName(userName);
            if(existingUser.isEmpty()){
                throw new IllegalArgumentException();
            }
            userRepository.delete(existingUser.get());
            return existingUser.get();
        }

       //updateUser
        public User updateUserByName(String userName, User user){
            Optional<User> existingUser = userRepository.findByUserName(userName);
            if(existingUser.isEmpty()){
                throw new IllegalArgumentException("This user does not exist");
            }
            User updatedUser = existingUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setMobileNr(user.getMobileNr());
            updatedUser.setRole(user.getRole());
            
            return userRepository.save(updatedUser);
        }

}
