package com.taskmaster.taskhandler;

import com.taskmaster.taskhandler.model.UserEntity;
import com.taskmaster.taskhandler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DatabaseLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        UserEntity build = UserEntity.builder().firstName("Sam").lastName("Windu").build();
        this.repository.save(build);
    }
}