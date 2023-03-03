package dev.danvega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String uid;
    private String name;
    private String type;
    private Date startDate;
    private Date endDate;
    private String parentUid;

    public Task() {
    }
}


