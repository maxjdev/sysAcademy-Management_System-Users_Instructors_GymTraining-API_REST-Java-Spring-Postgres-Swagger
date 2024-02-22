package com.sysAcademy.utils.converter.training_plan;

import com.sysAcademy.dto.TrainingPlanDTO;
import com.sysAcademy.entity.TrainingPlan;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class TrainPlanToDTOConverter implements Function<TrainingPlan, TrainingPlanDTO> {
    @Override
    public TrainingPlanDTO apply(TrainingPlan trainingPlan) {
        return new TrainingPlanDTO(
                trainingPlan.getDescription(),
                trainingPlan.getUser().getId(),
                trainingPlan.getInstructor().getId()
        );
    }
}