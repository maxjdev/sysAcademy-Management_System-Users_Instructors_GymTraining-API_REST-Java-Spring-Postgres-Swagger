package com.sysAcademy.service.impl;

import com.sysAcademy.dto.TrainingPlanDTO;
import com.sysAcademy.entity.*;
import com.sysAcademy.repository.*;
import com.sysAcademy.service.ITrainingPlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author maxdev
 */
@Service
public class TrainingPlanService implements ITrainingPlanService {
    // DI
    private final TrainingPlanRepository repository;
    private final UserRepository userRepository;
    private final InstructorRepository instructorRepository;
    private final Function<TrainingPlan, TrainingPlanDTO> toDTO;
    private final Function<TrainingPlanDTO, TrainingPlan> toEntity;
    public TrainingPlanService(
            TrainingPlanRepository repository,
            UserRepository userRepository,
            InstructorRepository instructorRepository,
            Function<TrainingPlan, TrainingPlanDTO> toDTO,
            Function<TrainingPlanDTO, TrainingPlan> toEntity
    ) {
        this.repository = repository;
        this.toDTO = toDTO;
        this.toEntity = toEntity;
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
    }
    // Methods
    @Override
    public List<TrainingPlanDTO> findAllTrainingPlans() {
        List<TrainingPlan> trainingPlans = repository.findAll();
        return trainingPlans.stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public TrainingPlanDTO getTrainPlanById(Long id) {
        TrainingPlan trainingPlan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> training plan with " + id + " not found <***"));
        return toDTO.apply(trainingPlan);
    }
    @Override
    public TrainingPlanDTO createTrainingPlan(TrainingPlanDTO dto) {
        TrainingPlan trainingPlan = toEntity.apply(dto);
        TrainingPlan trainingPlanSaved = repository.save(trainingPlan);
        return toDTO.apply(trainingPlanSaved);
    }
    public TrainingPlanDTO createTrainingPlan1(TrainingPlanDTO dto) {
        User user =  userRepository.findById(dto.getUserID())
                .orElseThrow(() -> new RuntimeException("***> user with " + dto.getUserID() + " not found <***"));
        Instructor instructor = instructorRepository.findById(dto.getInstructorID())
                .orElseThrow(() -> new RuntimeException("***> instructor with " + dto.getInstructorID() + " not found <***"));
        TrainingPlan train = new TrainingPlan(user, instructor, dto.getDescription());
        TrainingPlan trainSaved = repository.save(train);
        return toDTO.apply(trainSaved);
    }
    @Override
    public TrainingPlanDTO updateTrain(Long id, TrainingPlanDTO dto) {
        TrainingPlan trainingPlan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> training plan with " + id + " not found <***"));
        Instructor instructor = instructorRepository.findById(dto.getInstructorID())
                .orElseThrow(() -> new RuntimeException("***> instructor with " + id + " not found <***"));
        User user = userRepository.findById(dto.getUserID())
                        .orElseThrow(() -> new RuntimeException("***> user with " + id + " not found <***"));
        trainingPlan.setDescription(dto.getDescription());
        trainingPlan.setUser(user);
        trainingPlan.setInstructor(instructor);
        TrainingPlan trainUpdated = repository.save(trainingPlan);
        return toDTO.apply(trainUpdated);
    }
    @Override
    public void deleteTrainById(Long id) {
        TrainingPlan trainingPlan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> training plan with " + id + " not found <***"));
        repository.delete(trainingPlan);
    }
}