package com.sakthiit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.CreateCaseResponse;
import com.sakthiit.service.DcService;

@RestController
public class CreateCaseRestController {
	
	@Autowired
	private DcService dcService;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId){
		
		Long caseNum = dcService.loadCaseNum(appId);
		
		Map<Integer,String> planNames =dcService.getPlanNames();
		
		CreateCaseResponse response = new CreateCaseResponse();
		response.setCaseNum(caseNum);
		response.setPlanNames(planNames);
		
		return new ResponseEntity<CreateCaseResponse>(response, HttpStatus.OK);
		
	}
	
}
