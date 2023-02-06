package com.user.service.controller;

import com.user.service.model.ResponseDTO;
import com.user.service.model.User;
import com.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Value("${test-properties.version}")
    private Integer version;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<com.user.service.repo.User>> getUser(@PathVariable("id") Long id) {
        Optional<com.user.service.repo.User> response =  userService.getUser(id);
        if (response!=null)
            return ResponseEntity.ok(response);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<com.user.service.repo.User > createUser(@RequestBody User user) {
        com.user.service.repo.User response= userService.createUser(user);
       if(response !=null )
           return ResponseEntity.ok(response);
       else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable("id") Long id) {
       userService.deleteUser(id);

    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<com.user.service.repo.User> updateUser(@PathVariable("id") Long id) {
        return userService.updateUser(id);
    }


    @GetMapping ("/health")
    public ResponseEntity<ResponseDTO> healthCheck() {
        var responseDto = new ResponseDTO();
        responseDto.setVersion(version);
        return ResponseEntity.ok(responseDto);
    }
}
