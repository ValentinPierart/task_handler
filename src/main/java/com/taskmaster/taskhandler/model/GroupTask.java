package com.taskmaster.taskhandler.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class GroupTask extends Task{

    @OneToMany
    private List<Task> subTasks;

}
