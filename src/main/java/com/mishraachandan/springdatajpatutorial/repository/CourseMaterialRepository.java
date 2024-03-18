package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
