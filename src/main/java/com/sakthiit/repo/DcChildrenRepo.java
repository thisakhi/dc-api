package com.sakthiit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakthiit.entity.DcChildrensEntity;

public interface DcChildrenRepo extends JpaRepository<DcChildrensEntity, Serializable> {
	
	public List<DcChildrensEntity> findByCaseNum(Long caseNum);

}


