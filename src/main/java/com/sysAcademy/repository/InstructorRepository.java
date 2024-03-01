package com.sysAcademy.repository;

import com.sysAcademy.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maxdev
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {}