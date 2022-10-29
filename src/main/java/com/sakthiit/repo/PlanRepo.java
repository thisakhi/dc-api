package com.sakthiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakthiit.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {

}
