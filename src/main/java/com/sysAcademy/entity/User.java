package com.sysAcademy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

/**
 * @author maxdev
 */
@Data @NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    @CPF(message = "***** CPF: '${validatedValue}' is invalid *****")
    private String cpf;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TrainingPlan> trainingPlanList;

    public User(String name, String cpf, String address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }
}