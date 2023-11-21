package com.company.dto.response;

import com.company.dao.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    List<Status> findByIsDeletedTrue();


    List<Status> findByTaskIdInAndIsDeleted(List<Long> taskId, Boolean isDeleted);

    List<Status> findByTaskIdInAndIsArchive(List<Long> taskId, Boolean isArchive);

    List<Status> findByTaskIdInAndIsComplete(List<Long> taskId, Boolean isComplete);

    List<Status> findByTaskIdInAndIsImportant(List<Long> taskId, Boolean isImportnant);

    List<Status> findByTaskIdInAndIsTasks(List<Long> taskId, Boolean tasks);

    void deleteByTaskId(Long taskId);
}
