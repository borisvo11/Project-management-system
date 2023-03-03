package dev.danvega.repository;

import dev.danvega.domain.User;
import dev.danvega.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, String> {
    List<Task> findByName(String name);
    List<Task> findByParentUid(String parentUid);
    List<Task> findByUid(String Uid);
//    @Query("SELECT name FROM task  WHERE parentuid = ?1")
//    String findByParentUidID(String parentuid);

}
