package com.company.dao.repository;

import com.company.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);

//    @Modifying
//    @Query("DELETE FROM Task t WHERE t = :task")
//    void deleteTask(@Param("task") Task task);
}
