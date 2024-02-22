package com.sysAcademy.utils.converter.training_plan;

import com.sysAcademy.dto.TrainingPlanDTO;
import com.sysAcademy.entity.Instructor;
import com.sysAcademy.entity.TrainingPlan;
import com.sysAcademy.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class DTOToTrainPlanConverter implements Function<TrainingPlanDTO, TrainingPlan> {
    @Override
    public TrainingPlan apply(TrainingPlanDTO trainingPlanDTO) {
        User user = new User();
        user.setId(trainingPlanDTO.getUserID());

        Instructor instructor = new Instructor();
        instructor.setId(trainingPlanDTO.getInstructorID());

        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setUser(user);
        trainingPlan.setInstructor(instructor);
        trainingPlan.setDescription(trainingPlanDTO.getDescription());
        return trainingPlan;
    }
}