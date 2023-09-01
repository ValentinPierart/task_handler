package com.taskmaster.taskhandler.repository;

import com.taskmaster.taskhandler.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findById(long id);
}
