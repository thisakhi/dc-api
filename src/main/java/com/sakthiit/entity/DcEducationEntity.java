package com.sakthiit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DC_EDUCATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DcEducationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	private Long caseNum;
	private String highestQualification;
	private Integer graduationYear;
	private String universityName;
	 

}
