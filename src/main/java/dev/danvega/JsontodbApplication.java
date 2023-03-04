package dev.danvega;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.domain.User;
import dev.danvega.model.Task;
import dev.danvega.service.TaskService;
import dev.danvega.service.UserService;
import dev.danvega.util.TimeZero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JsontodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsontodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskService taskService) {
        return args -> {
            // read JSON and load json
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Task>> typeReference = new TypeReference<List<Task>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/proj.json");
            try {
                Map<String, List<Task>> userData = mapper.readValue(
                        inputStream, new TypeReference<Map<String, List<Task>>>() {
                        });
                for (List<Task> value : userData.values()) {
                    for (Task task : value) {
                        taskService.save(task);
                        taskService.updateStatus(task);
                    }
                }
                System.out.println("Tasks Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save tasks: " + e.getMessage());
            }
        };
    }
//	@Bean
//	CommandLineRunner runner(UserService userService){
//	    return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//			try {
//				List<User> users = mapper.readValue(inputStream,typeReference);
//				userService.save(users);
//				System.out.println("Users Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//	    };
//	}
}
