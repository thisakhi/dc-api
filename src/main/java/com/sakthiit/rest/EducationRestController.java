package com.sakthiit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.DcEducationBinding;
import com.sakthiit.service.DcService;

@RestController
public class EducationRestController {
	
	@Autowired
	private DcService dcService;
	
	@PostMapping("/education")
	private ResponseEntity<Long> planSelection(@RequestBody DcEducationBinding education) {

		Long caseNum = dcService.saveEducation(education);

		return new ResponseEntity(caseNum, HttpStatus.CREATED);
	}

}
