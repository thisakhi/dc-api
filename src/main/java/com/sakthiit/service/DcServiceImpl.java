package com.sakthiit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakthiit.binding.ChildRequest;
import com.sakthiit.binding.DcChildrensBinding;
import com.sakthiit.binding.DcEducationBinding;
import com.sakthiit.binding.DcIncomeBinding;
import com.sakthiit.binding.DcPlanSelectionBinding;
import com.sakthiit.binding.DcSummaryBinding;
import com.sakthiit.entity.CitizenAppEntiry;
import com.sakthiit.entity.DcCasesEntity;
import com.sakthiit.entity.DcChildrensEntity;
import com.sakthiit.entity.DcEducationEntity;
import com.sakthiit.entity.DcIncomeEntity;
import com.sakthiit.entity.PlanEntity;
import com.sakthiit.repo.CitizenAppRepositery;
import com.sakthiit.repo.DcCasesRepo;
import com.sakthiit.repo.DcChildrenRepo;
import com.sakthiit.repo.DcEducationRepo;
import com.sakthiit.repo.DcIncomeRepo;
import com.sakthiit.repo.PlanRepo;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private DcCasesRepo casesRepo;

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private DcIncomeRepo incomeRepo;

	@Autowired
	private DcEducationRepo educationRepo;

	@Autowired
	private DcChildrenRepo childrenRepo;

	@Autowired
	private CitizenAppRepositery citizenAppRepositery;

	public Long loadCaseNum(Integer appId) {

		Optional<CitizenAppEntiry> findById = citizenAppRepositery.findById(appId);

		if (findById.isPresent()) {
			DcCasesEntity entity = new DcCasesEntity();
			entity.setAppId(appId);
			casesRepo.save(entity);
			return entity.getCaseNum();
		}
		
		return 0l;
	}

	public Map<Integer,String> getPlanNames() {
		List<PlanEntity> findAll = planRepo.findAll();

		Map<Integer,String>  planMap = new HashMap<Integer,String>();

		for (PlanEntity entity : findAll) {

			planMap.put(entity.getPlanId(),entity.getPlanName());

		}
		return planMap;
	}

	public Long savePlanSelection(DcPlanSelectionBinding planSelection) {
		
		
		Optional<DcCasesEntity> findById = casesRepo.findById(planSelection.getCaseNum());
		
		if(findById.isPresent()) {
			DcCasesEntity entity = findById.get();
			entity.setPlanId(planSelection.getPlanId());
			casesRepo.save(entity);
			return entity.getCaseNum();
		}
		return null;
	}

	public Long saveIncomeData(DcIncomeBinding income) {

		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);
		incomeRepo.save(entity);

		return income.getCaseNum();
	}

	public Long saveEducation(DcEducationBinding education) {

		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(education, entity);
		educationRepo.save(entity);

		return education.getCaseNum();
	}

	public Long saveChildern(ChildRequest request) {
		
		List<DcChildrensBinding>  childs = request.getChilds();
		
		Long caseNum = request.getCaseNum();
				
		for (DcChildrensBinding c : childs) {

			DcChildrensEntity entity = new DcChildrensEntity();
			
			BeanUtils.copyProperties(c, entity);
			entity.setCaseNum(caseNum);
			childrenRepo.save(entity);
		}

		return request.getCaseNum();

	}

	public DcSummaryBinding getDcSummary(Long caseNum) {

		String planName = "";

		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
		DcEducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);
		List<DcChildrensEntity> childsEntity = childrenRepo.findByCaseNum(caseNum);
		Optional<DcCasesEntity> dcCaseEntity = casesRepo.findById(caseNum);

		if (dcCaseEntity.isPresent()) {
			Integer planId = dcCaseEntity.get().getPlanId();
			Optional<PlanEntity> plan = planRepo.findById(planId);
			if (plan.isPresent()) {
				planName = plan.get().getPlanName();
			}
		}
		DcSummaryBinding dcSummaryBinding = new DcSummaryBinding();
		dcSummaryBinding.setPlanName(planName);

		DcIncomeBinding income = new DcIncomeBinding();
		BeanUtils.copyProperties(incomeEntity, income);
		dcSummaryBinding.setIncome(income);

		DcEducationBinding education = new DcEducationBinding();
		BeanUtils.copyProperties(educationEntity, education);
		dcSummaryBinding.setEducation(education);

		List<DcChildrensBinding> child = new ArrayList<DcChildrensBinding>();
		for (DcChildrensEntity entity : childsEntity) {

			DcChildrensBinding ch = new DcChildrensBinding();
			BeanUtils.copyProperties(entity, ch);
			child.add(ch);
		}

		dcSummaryBinding.setChild(child);

		return dcSummaryBinding;
	}

}
