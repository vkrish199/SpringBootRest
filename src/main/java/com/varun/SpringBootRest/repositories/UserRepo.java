package com.varun.SpringBootRest.repositories;

import com.varun.SpringBootRest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
