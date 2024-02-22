package com.sysAcademy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxdev
 */
@Data @NoArgsConstructor
@Entity
@Table(name = "tb_instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialty;
    public Instructor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }
}
