package com.taskmaster.taskhandler.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskmaster.taskhandler.model.UserEntity;
import com.taskmaster.taskhandler.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    @GetMapping("/users")
    Collection<UserEntity> users() {
	return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
	Optional<UserEntity> user = userRepository.findById(id);
	return user.map(response -> ResponseEntity.ok().body(response))
		.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user")
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) throws URISyntaxException {
	UserEntity result = userRepository.save(user);
	return ResponseEntity.created(new URI("/api/user/" + result.getId())).body(result);
    }

    @PutMapping("/user/{id}")
    ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
	UserEntity result = userRepository.save(user);
	return ResponseEntity.ok().body(result);
    }
}
