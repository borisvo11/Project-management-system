package com.baruchv.repository;

import com.baruchv.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByName(String name);
    List<Task> findByParentUid(String parentUid);
    List<Task> findByUid(String Uid);
    void deleteByUid(String Uid);

}
