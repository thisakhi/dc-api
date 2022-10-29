package com.sakthiit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private Integer planId;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_SATRT_DATE")
	private LocalDate planStartDate;
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "ACTIVE_SW")
	private String activesw;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "UPATED_BY")
	private String updatedBy;

	@Column(name = "UODATED_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updatedDate;

}
