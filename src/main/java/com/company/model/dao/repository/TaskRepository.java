package com.company.model.dao.repository;

import com.company.model.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);

    void deleteById(Long id);

    @Modifying
    @Query("DELETE FROM Task t WHERE t.id = :taskId")
       void deleteTask(@Param("taskId") Long taskId);
}
