package com.sysAcademy.repository;

import com.sysAcademy.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maxdev
 */
@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {}