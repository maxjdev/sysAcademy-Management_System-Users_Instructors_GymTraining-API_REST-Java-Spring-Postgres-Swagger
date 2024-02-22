package com.sysAcademy.controller;

import com.sysAcademy.dto.TrainingPlanDTO;
import com.sysAcademy.service.ITrainingPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maxdev
 */
@RestController
@RequestMapping("/train")
@Tag(name = "TrainingPlan Controller", description = "API for training plan management")
public class TrainController {
    // DI
    private final ITrainingPlanService service;
    public TrainController(ITrainingPlanService planService) {
        this.service = planService;
    }
    // Requests
    @Operation(summary = "List all training plans", description = "Return List<TrainingPlanDTO>")
    @GetMapping
    public ResponseEntity<List<TrainingPlanDTO>> findAllTrains() {
        try {
            List<TrainingPlanDTO> trains = service.findAllTrainingPlans();
            return ResponseEntity.ok(trains);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Find training plan by id", description = "Return TrainingPlanDTO")
    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlanDTO> getTrainById(@PathVariable Long id) {
        try {
            TrainingPlanDTO train = service.getTrainPlanById(id);
            return ResponseEntity.ok(train);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Create a train", description = "Return TrainingPlanDTO")
    @PostMapping
    public ResponseEntity<TrainingPlanDTO> createTrain(@Valid @RequestBody TrainingPlanDTO dto) {
        try {
            TrainingPlanDTO trainCreated = service.createTrainingPlan(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(trainCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Update a train", description = "Return TrainingPlanDTO")
    @PutMapping("/{id}")
    public ResponseEntity<TrainingPlanDTO> updateTrain(@PathVariable Long id, @Valid @RequestBody TrainingPlanDTO dto) {
        try {
            TrainingPlanDTO trainUpdated = service.updateTrain(id, dto);
            return ResponseEntity.ok(trainUpdated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Delete a train", description = "Return Void")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainById(@PathVariable Long id) {
        try {
            service.deleteTrainById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}