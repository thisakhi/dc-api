package com.sakthiit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.DcPlanSelectionBinding;
import com.sakthiit.service.DcService;

@RestController
public class PlanSelectionRestController {
	
	@Autowired
	private DcService dcService;
	
	@PostMapping("/plansel")
	private ResponseEntity<Long> planSelection(@RequestBody  DcPlanSelectionBinding planSel) {
		
		Long caseNum = dcService.savePlanSelection(planSel);
		
		return new ResponseEntity(caseNum, HttpStatus.CREATED);
	}

}
