package com.example.TaskManager.repositories;

import com.example.TaskManager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>
{
}
