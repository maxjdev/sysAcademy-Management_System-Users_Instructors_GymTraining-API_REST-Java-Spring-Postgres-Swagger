package com.sysAcademy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxdev
 */
@Data @NoArgsConstructor
@Entity
@Table(name = "tb_train_plan")
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public TrainingPlan(User user, Instructor instructor, String description) {
        this.user = user;
        this.instructor = instructor;
        this.description = description;
    }
}
