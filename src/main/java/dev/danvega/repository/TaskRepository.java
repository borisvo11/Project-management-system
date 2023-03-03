package dev.danvega.repository;

import dev.danvega.domain.User;
import dev.danvega.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {
}
