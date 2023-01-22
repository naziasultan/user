package com.user.service.service;

import com.user.service.repo.User;
import com.user.service.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Optional<User> getUser(Long id){
       return repository.findById(id);
    }
    public User createUser(com.user.service.model.User user){
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setAmountOfPosts(user.getAmountOfPosts());
        repository.save(newUser);
        return newUser;
    }
    public void deleteUser(Long id){
      repository.deleteById(id);

    }

    public Optional<User> updateUser(Long id){
        Optional<User> updatedUser = repository.findById(id);

        if(updatedUser.isPresent()) {
            Integer i = Integer.valueOf(updatedUser.get().getAmountOfPosts()) + 1;
            updatedUser.get().setAmountOfPosts(String.valueOf(i));
        }
        return updatedUser;
    }
}
