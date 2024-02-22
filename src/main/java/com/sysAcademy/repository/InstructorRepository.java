package com.sysAcademy.repository;

import com.sysAcademy.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maxdev
 */
public interface InstructorRepository extends JpaRepository<Instructor, Long> {}