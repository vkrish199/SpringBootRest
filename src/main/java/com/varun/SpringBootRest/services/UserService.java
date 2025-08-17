package com.varun.SpringBootRest.services;


import com.varun.SpringBootRest.models.User;
import com.varun.SpringBootRest.models.UserPrincipal;
import com.varun.SpringBootRest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
       User user = userRepo.findByUsername(username);
       if(user==null) {
           System.out.println("User not found : 404");
           throw new UsernameNotFoundException("User not found : 440");
       }

       return new UserPrincipal(user);
    }

    public void createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(new User());
    }
}
