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
@Table(name = "DC_INCOME")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DcIncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	private Long caseNum;
	private Double empIncome;
	private Double propertyIncome;
	private Integer ssn;
	 
}
