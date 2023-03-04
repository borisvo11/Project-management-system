package dev.danvega.repository;

import dev.danvega.domain.User;
import dev.danvega.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByName(String name);
    List<Task> findByParentUid(String parentUid);
    List<Task> findByUid(String Uid);
    void deleteByUid(String Uid);

}
