package com.isak.footballapp.repository;

import com.isak.footballapp.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional <User> findByUserName(String userName);
    Optional<User> findUserByEmail(String email);

}
