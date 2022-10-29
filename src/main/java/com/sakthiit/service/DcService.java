package com.sakthiit.service;

import java.util.Map;

import com.sakthiit.binding.ChildRequest;
import com.sakthiit.binding.DcEducationBinding;
import com.sakthiit.binding.DcIncomeBinding;
import com.sakthiit.binding.DcPlanSelectionBinding;
import com.sakthiit.binding.DcSummaryBinding;

public interface DcService {

	public Long loadCaseNum(Integer appId);
	public Map<Integer,String> getPlanNames();
	public Long savePlanSelection(DcPlanSelectionBinding planSelection);
	public Long saveIncomeData(DcIncomeBinding income);
	public Long saveEducation(DcEducationBinding education);
	public Long saveChildern(ChildRequest request);
	public DcSummaryBinding getDcSummary(Long caseNum);

	 
	
}
