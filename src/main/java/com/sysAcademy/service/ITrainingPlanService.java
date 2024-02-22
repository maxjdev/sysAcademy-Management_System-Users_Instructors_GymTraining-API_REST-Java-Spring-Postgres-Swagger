package com.sysAcademy.service;

import com.sysAcademy.dto.TrainingPlanDTO;
import java.util.List;

/**
 * @author maxdev
 */
public interface ITrainingPlanService {
    public List<TrainingPlanDTO> findAllTrainingPlans();
    TrainingPlanDTO getTrainPlanById(Long id);
    TrainingPlanDTO createTrainingPlan(TrainingPlanDTO dto);
    TrainingPlanDTO updateTrain(Long id, TrainingPlanDTO dto);
    void deleteTrainById(Long id);
}