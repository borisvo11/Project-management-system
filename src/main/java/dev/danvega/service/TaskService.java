package dev.danvega.service;

import dev.danvega.model.Task;
import dev.danvega.repository.TaskRepository;
import dev.danvega.util.TimeZero;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Iterable<Task> list() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void save(List<Task> tasks) {
        repository.saveAll(tasks);
    }

    public void updateDate(String uid,java.sql.Date startDate,java.sql.Date endDate) {
        List<Task> task = repository.findByUid(uid);
        task.get(0).setStartDate(startDate);
        task.get(0).setEndDate(endDate);
        repository.save(task.get(0));
    }

    public void deleteTask(String uid) {
        repository.deleteByUid(uid);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void updateStatus(Task task) {
        if (task.getType().equals("TASK")) {
            while (true) {
                LocalDate startDate = task.getStartDate().toLocalDate();
                LocalDate endDate = task.getEndDate().toLocalDate();
                String parentId = task.getParentUid();

                List<Task> parent = repository.findByUid(parentId);
                boolean date1_start;
                boolean date1_end;
                try {
                    LocalDate startDate_parent = parent.get(0).getStartDate().toLocalDate();
                    date1_start = startDate.isBefore(startDate_parent);
                } catch (NullPointerException e) {
                    date1_start = true;
                }
                try {
                    LocalDate endDate_parent = parent.get(0).getEndDate().toLocalDate();
                    date1_end = endDate.isAfter(endDate_parent);
                } catch (NullPointerException e) {
                    date1_end = true;
                }

                if (!date1_end  && !date1_start )
                    break;
                else {
                    if (date1_start ) {
                        parent.get(0).setStartDate(java.sql.Date.valueOf(startDate));
                        repository.save(parent.get(0));
                    }
                    if (date1_end ) {
                        parent.get(0).setEndDate(java.sql.Date.valueOf(endDate));
                        repository.save(parent.get(0));
                    }
                    if (parent.get(0).getParentUid() == null)
                        break;
                    task = parent.get(0);
                }
            }
        }
    }
}




