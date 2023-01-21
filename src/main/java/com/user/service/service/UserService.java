package com.user.service.service;

import com.user.service.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<Long, User> mapUser= new HashMap<>();

    public User getUser(Long id){
       return mapUser.get(id);
    }
    public User createUser(User user){
         User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .amountOfPosts(user.getAmountOfPosts())
                .build();
        mapUser.put(user.getId(), user);
        return user;
    }
    public void deleteUser(Long id){
        mapUser.remove(id);
    }

    public User updateUser(Long id){
        User user = mapUser.get(id);
        user.setId(id);
        mapUser.put(id, user);
        return user;
    }
}
