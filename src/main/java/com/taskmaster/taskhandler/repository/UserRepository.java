package com.taskmaster.taskhandler.repository;

import com.taskmaster.taskhandler.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findById(long id);
}
