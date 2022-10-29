package com.sakthiit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.ChildRequest;
import com.sakthiit.binding.DcSummaryBinding;
import com.sakthiit.service.DcService;

@RestController
public class ChildernRestController {
	
	@Autowired
	private DcService dcService;
	
	@PostMapping("/childrens")
	public ResponseEntity<DcSummaryBinding> saveChild(@RequestBody ChildRequest request){
		
		Long caseNum=dcService.saveChildern(request);
		DcSummaryBinding dcSummary = dcService.getDcSummary(caseNum);
		 
		return  new ResponseEntity<DcSummaryBinding>(dcSummary,HttpStatus.OK);
		
	}

}
