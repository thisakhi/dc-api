package com.sakthiit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.DcIncomeBinding;
import com.sakthiit.service.DcService;

@RestController
public class IncomeRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/income")
	private ResponseEntity<Long> planSelection(@RequestBody DcIncomeBinding income) {

		Long caseNum = dcService.saveIncomeData(income);

		return new ResponseEntity(caseNum, HttpStatus.CREATED);
	}

}
